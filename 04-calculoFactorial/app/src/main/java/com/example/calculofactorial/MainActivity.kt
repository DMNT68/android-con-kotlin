package com.example.calculofactorial

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numeroIngresado = findViewById<EditText>(R.id.editTextNumber)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val resultado = findViewById<TextView>(R.id.resultado)


        btnCalcular.setOnClickListener {
            val numero = numeroIngresado.text.toString().toIntOrNull()
            if (numero != null) {
                val factorial = calcularFactorial(numero)
                resultado.text = "El factorial de $numero es $factorial"
            } else resultado.text = "Por favor ingrese un número válido"
        }

    }

    private fun calcularFactorial(numero: Int): Long {
        var resultado = 1L
        for (i in 2..numero) {
            resultado *= i
            println("$i ---> $resultado")
        }
        return resultado
    }
}