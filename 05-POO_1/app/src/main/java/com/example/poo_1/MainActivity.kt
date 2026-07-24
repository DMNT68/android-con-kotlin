package com.example.poo_1

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.poo_1.model.RectaguloSinBordes
import com.example.poo_1.model.Rectangulo
import com.example.poo_1.model.RectanguloConBordes
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rectanguloView = findViewById<View>(R.id.rectangulo)
        rectanguloView.post {
            val inicialX = rectanguloView.x.toInt()
            val inicialY = rectanguloView.y.toInt()
            val inicialWidth = rectanguloView.width
            val inicialHeight = rectanguloView.height
            // println("Coordenadas iniciales: x=$inicialX, y=$inicialY")
            // println("Tamaño inicial: width=$inicialWidth, height=$inicialHeight")

            // val rectangulo:Rectangulo = Rectangulo(ContextCompat.getColor(this, R.color.red), inicialWidth, inicialHeight,inicialX, inicialY)
           /* val rectangulo = RectanguloConBordes(ContextCompat.getColor(this, R.color.red), inicialWidth, inicialHeight).apply {
                x = inicialX
                y = inicialY
                colorBorde = ContextCompat.getColor(this@MainActivity, R.color.black)
            }*/

            val rectangulo = RectaguloSinBordes(ContextCompat.getColor(this, R.color.red), inicialWidth, inicialHeight).apply {
                // x = inicialX
                // y = inicialY
                dimensiones.x = inicialX
                dimensiones.y = inicialY
            }

            // Quitar los bordes

            rectangulo.eliminarBordes()
            actualizarVista(rectangulo,rectanguloView)


            val btnArriba = findViewById<Button>(R.id.btnArriba)
            val btnAbajo = findViewById<Button>(R.id.btnAbajo)
            val btnIzquierda = findViewById<Button>(R.id.btnIzquierda)
            val btnDerecha = findViewById<Button>(R.id.btnDerecha)
            val btnCambiarTamano = findViewById<Button>(R.id.btnCambiarTamano)
            val btnCambiarColor = findViewById<Button>(R.id.btnCambiarColor)
            val btnCambiarColorBorde = findViewById<Button>(R.id.btnCambiarColorBorde)

            btnArriba.setOnClickListener {
                rectangulo.moverArriba()
                actualizarVista(rectangulo, rectanguloView)
            }

            btnAbajo.setOnClickListener {
                rectangulo.moverAbajo()
                actualizarVista(rectangulo, rectanguloView)
            }

            btnIzquierda.setOnClickListener {
                rectangulo.moverIzquierda()
                actualizarVista(rectangulo, rectanguloView)
            }

            btnDerecha.setOnClickListener {
                rectangulo.moverDerecha()
                actualizarVista(rectangulo, rectanguloView)
            }

            btnCambiarTamano.setOnClickListener {
                rectangulo.cambiarTamano( Random.nextInt(80,601), Random.nextInt(80,601))
                actualizarVista(rectangulo, rectanguloView)
            }

            btnCambiarColor.setOnClickListener {
                // val colores = listOf(ContextCompat.getColor(this, R.color.red), ContextCompat.getColor(this, R.color.blue), ContextCompat.getColor(this, R.color.black))
                // rectangulo.cambiarColor(colores[Random.nextInt(colores.size)])
                rectangulo.cambiarColor(generarColoresAleatorios())
                actualizarVista(rectangulo, rectanguloView)
            }

            btnCambiarColorBorde.setOnClickListener {
                // rectangulo.cambiarColorBorde(generarColoresAleatorios())
                // accedemos a la clase nested
                rectangulo.cambiarColorBorde(RectanguloConBordes.ManejoColor.obtenerColorAleatorio())
                actualizarVista(rectangulo, rectanguloView)
            }

        }


    }

    private fun generarColoresAleatorios(): Int {
        val random = Random.Default
        val rojo = random.nextInt(256)
        val verde = random.nextInt(256)
        val azul = random.nextInt(256)
        return Color.rgb(rojo, verde, azul)
    }

    private fun actualizarVista(rectangulo: RectanguloConBordes, rectanguloView: View){
        val drawable = GradientDrawable()
        drawable.setColor(rectangulo.color)
        drawable.setStroke(10, rectangulo.colorBorde)
        // rectanguloView.setBackgroundColor(rectangulo.color)
        rectanguloView.background = drawable

        // rectanguloView.layoutParams.width = rectangulo.base
        // rectanguloView.layoutParams.height = rectangulo.altura
        rectanguloView.layoutParams.width = rectangulo.dimensiones.ancho
        rectanguloView.layoutParams.height = rectangulo.dimensiones.alto

        //rectanguloView.x = rectangulo.x.toFloat()
        //rectanguloView.y = rectangulo.y.toFloat()
        rectanguloView.x = rectangulo.dimensiones.x.toFloat()
        rectanguloView.y = rectangulo.dimensiones.y.toFloat()


        rectanguloView.requestLayout()
    }
}