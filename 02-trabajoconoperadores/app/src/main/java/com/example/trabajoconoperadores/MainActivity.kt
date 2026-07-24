package com.example.trabajoconoperadores

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.trabajoconoperadores.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val miNumero:EditText = findViewById(R.id.edad)
        val miBoton:Button = findViewById(R.id.button)
        val textoResultado:TextView = findViewById(R.id.mensajes)

        val botonSumar:Button = findViewById(R.id.botonSumar)
        val botonRestar:Button = findViewById(R.id.botonRestar)

        miBoton.setOnClickListener{
            val numeroResultado = miNumero.text.toString().toIntOrNull()

           /* primera manera
            if(numeroResultado == null) textoResultado.text = "Ingrese un valor"
            else if(numeroResultado < 18) textoResultado.text = "Eres menor de edad"
            else if (numeroResultado > 18 ) textoResultado.text = "Eres mayor de edad"
            else textoResultado.text = "tienes justo 18"
           */
            /* segunda manera
            textoResultado.text = if(numeroResultado == null) "Ingrese un valor"
            else if(numeroResultado < 18)  "Eres menor de edad"
            else if (numeroResultado > 18 )  "Eres mayor de edad"
            else "tienes justo 18"
            */
            // tercera manera
            actulizarMensajeSegunEdad(numeroResultado, textoResultado)
        }

        botonSumar.setOnClickListener{
            var numeroResultado = miNumero.text.toString().toIntOrNull()
            if(numeroResultado == null) textoResultado.text = "Ingrese un valor"
            else{
                miNumero.setText((++numeroResultado).toString())
                // textoResultado.text = mensajeSegunEdad(numeroResultado)
                actulizarMensajeSegunEdad(numeroResultado, textoResultado)
            }

        }

        botonRestar.setOnClickListener{
            var numeroResultado = miNumero.text.toString().toIntOrNull()
            if(numeroResultado == null) textoResultado.text = "Ingrese un valor"

            else {
                miNumero.setText((--numeroResultado).toString())
                // textoResultado.text = mensajeSegunEdad(numeroResultado)

                actulizarMensajeSegunEdad(numeroResultado, textoResultado)
            }

        }
    }

    private fun mensajeSegunEdad (edad:Int):String {
        return if(edad < 18) "Eres menor de edad"
        else if (edad > 18 ) "Eres mayor de edad"
        else "tienes justo 18"
    }

    private fun actulizarMensajeSegunEdad (edad:Int?, textoResultado:TextView) {
      val mensaje = when {
          !(edad !== null) -> "Ingrese un valor"

          // Ejemplo 3
           !(edad >= 18 && edad <= 25 || edad > 65 && edad <= 75) -> "A pagar el abono completo"
          // edad < 18 || edad > 75 -> "Viajas gratis"
           else -> "Tienes descuento en abono"


      // Ejemplo 2
      // edad >= 18 && edad <= 25 || edad > 65 && edad <= 75 -> "Tienen descuento en abono"
      // edad < 18 || edad > 75 -> "Viajas gratis"
      // else -> "A pagar el abono completo"

      // Ejemplo 1
      // edad < 1  || edad > 110 -> "Introduce una edad lógica"
      // edad < 18 || edad > 80 -> "Lo siento no podemos darte el permiso de conducir"
      // edad > 18 && edad <=30 -> "Eres un adulto joven"
      // edad > 30 -> "Eres madur@"
      // else -> "tienes acceso al permiso de conducir"
      }
        textoResultado.text = mensaje
    }

}

