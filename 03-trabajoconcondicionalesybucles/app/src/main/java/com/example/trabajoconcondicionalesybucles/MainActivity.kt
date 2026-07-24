package com.example.trabajoconcondicionalesybucles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    // para el uso de corutinas
    // var nuevoIntento = false // Flag para controlar los nuevos intentos
    // var valorIntroducido = 0    // Almacenar el valir introducido por el usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val numeroIntroducido:EditText = findViewById(R.id.entradaValor)
        val miBoton:Button = findViewById(R.id.button)
        val miBotonReiniciar:Button = findViewById(R.id.botonReiniciar)
        val mensajeSalida:TextView = findViewById(R.id.salidaMensaje)
        val contadorIntentos:TextView = findViewById(R.id.intentosContador)
        var numeroRandom = Random.nextInt(1,101)
        var intentos = 0

        contadorIntentos.text = "Intentos: $intentos"
        println("El número aleatorio es $numeroRandom")

        miBoton.setOnClickListener{
            val valorIntroducido = numeroIntroducido.text.toString().toIntOrNull()

            if(valorIntroducido === null ) {
                Toast.makeText(this,"Debe ingresar un número",Toast.LENGTH_SHORT).show()
                mensajeSalida.text="Debe ingresar un número"
            }
            else {
                // para el uso de corutinas
                // nuevoIntento = true // Marcamos que usuarios hizo un nuevo intento

                intentos++
                contadorIntentos.text = "Intentos: $intentos"
                val resultado = juegoAdivinaNumero(numeroRandom, valorIntroducido, intentos)
                mensajeSalida.text = resultado.mensaje

                if(resultado.respuesta){
                    intentos=0
                    numeroRandom = Random.nextInt(1,101)
                    miBoton.isEnabled = false
                    miBotonReiniciar.visibility = Button.VISIBLE
                    numeroIntroducido.isEnabled = false

                }

                numeroIntroducido.text.clear()
            }

        }
        /*
        // para el uso de corutinas
        GlobalScope.launch(Dispatchers.Main) {
            if(valorIntroducido !== null)
            while (numeroRandom !== valorIntroducido) {
                if(nuevoIntento) { // Verificar si se ha hecho un nuevo
                    intentos++
                    if(numeroRandom < valorIntroducido) mensajeSalida.text = "Más bajo"
                    else if(numeroRandom > valorIntroducido) mensajeSalida.text = "Más alto"
                    nuevoIntento=false
                }
                delay(500)
            }
            intentos=0
            numeroRandom = Random.nextInt(1,101)
            miBoton.isEnabled = false
            miBotonReiniciar.visibility = Button.VISIBLE
            numeroIntroducido.isEnabled = false
            mensajeSalida.text = "Acertaste, en ${intentos} intentos. El número secreto era $numeroRandom"
        }

         */

        miBotonReiniciar.setOnClickListener{
            intentos=0
            contadorIntentos.text = "Intentos: $intentos"
            mensajeSalida.text = ""
            numeroIntroducido.text.clear()
            numeroIntroducido.isEnabled = true
            miBoton.isEnabled = true
            miBotonReiniciar.visibility = Button.INVISIBLE
        }

    }
    data class Respuesta(val mensaje: String, val respuesta: Boolean)

    private fun juegoAdivinaNumero(numeroRandom: Int, valorIntroducido: Int, intentos:Int):Respuesta {
        println("El número aleatorio es $numeroRandom")
        if(valorIntroducido > numeroRandom) return Respuesta(mensaje ="$valorIntroducido es mayor que el número secreto. Debe ingresar un numero menor", respuesta = false)
        else if (valorIntroducido < numeroRandom) return Respuesta(mensaje ="$valorIntroducido es menor al número secreto. Debe ingresar un numero mayor", respuesta = false)
        else {
            Toast.makeText(this,"!!! FELICITACIONES GANASTE !!!",Toast.LENGTH_SHORT).show()
            return Respuesta(mensaje ="Acertaste, en ${intentos} intentos. El número secreto era $numeroRandom", respuesta = true)
        }
    }
}