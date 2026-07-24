package com.example.poo_1.model

import android.graphics.Color

class RectaguloSinBordes(color:Int, alto:Int, ancho:Int):RectanguloConBordes(color, ancho, alto) {

    override fun cambiarColorBorde (nuevoColor:Int) {
        colorBorde = nuevoColor
    }

    fun eliminarBordes(){
        colorBorde = Color.TRANSPARENT
    }

}