package com.example.pruebagopenux2
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.pruebagopenux2.databinding.CiudadesBinding

class MainActivity : ComponentActivity() {

    lateinit var binding: CiudadesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CiudadesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonEnviar = binding.buttonEnviar
        val editTextCiudad = binding.EditTextCiudad

        buttonEnviar.setOnClickListener {
            val ciudad = editTextCiudad.text.toString().trim()
            if (ciudad.isEmpty()) {
                editTextCiudad.error = "Por favor, ingresa el nombre de la ciudad"
            } else if (!isCityNameValid(ciudad)) {
                editTextCiudad.error = "Por favor, ingresa un nombre de ciudad válido (solo letras)"
            } else {
                val intent = Intent(this, WeatherActivity::class.java)
                intent.putExtra("Ciudades", ciudad)
                startActivity(intent)
            }
        }
    }

    private fun isCityNameValid(city: String): Boolean {
        return city.matches(Regex("[a-zA-Z]+"))
    }
}

