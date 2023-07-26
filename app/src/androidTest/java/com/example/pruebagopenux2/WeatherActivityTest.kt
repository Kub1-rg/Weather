package com.example.pruebagopenux2
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.net.HttpURLConnection

@RunWith(AndroidJUnit4::class)
class WeatherActivityTest {

    @get:Rule
    var activityRule: ActivityScenarioRule<WeatherActivity> = ActivityScenarioRule(WeatherActivity::class.java)

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        mockWebServer.start()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testWeatherDataDisplayed() {
        // Configura la respuesta simulada de la API
        val responseJson = """
            {
                "current": {
                    "temp": 25.0,
                    "feels_like": 26.5,
                    "humidity": 70
                }
            }
        """
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(responseJson)

        mockWebServer.enqueue(response)

        // Ejecuta el método que deseas probar con las coordenadas y la clave de la API simuladas
        val apiKey = "e3d3795f74cd75a102f6ae7453201e96"
        val lat = 3.4518
        val lon = -76.5325
        activityRule.scenario.onActivity { activity ->
            activity.WeatherBody(apiKey, lat, lon)
        }

        onView(withId(R.id.txtTmpActual)).check(matches(withText("25.0")))
        onView(withId(R.id.txtHumedad)).check(matches(withText("70")))
        onView(withId(R.id.txtSensacion)).check(matches(withText("26.5")))
    }
}
