package com.example.poo_1.model

import android.graphics.Color

open class RectanguloConBordes(color:Int, alto:Int, ancho:Int, var colorBorde:Int=Color.BLACK):Rectangulo(color, ancho, alto){

    // clases Nested o anidadas
    /*
    * Permite encapsular la lógica de una clase, tiene la posibilidad de implementación de esta clase sin afectar
    * al resto del codigo, esto fomenta la modularidad por que la lógica de esta clase es desacoplada a la lógica
    * de la clase principal.
    *
    * Reducción de duplicación de código,
    *
    * Visibilidad controlada, la clase solo se accede desde la clase principal, no desde otras clases.
    * */
    class ManejoColor {

        // Objetos compartidos por todas las instancias de esta clase
        companion object{
            val ROJO = Color.RED
            val AZUL = Color.BLUE
            val VERDE = Color.GREEN
            val BLACK = Color.BLACK

            fun obtenerColorAleatorio():Int{
                val colores = listOf(ROJO, AZUL, VERDE, BLACK)
                return colores.random()

            }
        }
    }

    open fun cambiarColorBorde(nuevoColor:Int){
        colorBorde = nuevoColor

    }
}