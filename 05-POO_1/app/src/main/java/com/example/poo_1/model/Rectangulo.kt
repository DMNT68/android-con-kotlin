package com.example.poo_1.model

open class Rectangulo(var color: Int, var base: Int, var altura: Int) {

    // Coordenandas iniciales. Props
    // var x: Int = 0
    // var y: Int = 0

    var dimensiones = MiDimension(0,0, base, altura)

    constructor(color: Int, base: Int, altura: Int, x: Int, y: Int) : this(color, base, altura){
        dimensiones.x = x
        dimensiones.y = y
    }

    // Métodos para mover el rectángulo

    fun moverArriba(){
        // y -= 100
        dimensiones.y -= 100
    }

    fun moverAbajo(){
        // y += 100
        dimensiones.y += 100
    }

    fun moverDerecha(){
        // x += 100
        dimensiones.x += 100
    }

    fun moverIzquierda(){
        // x -= 100
        dimensiones.x -= 100
    }

    // Métodos para cambiar el tamaño del rectángulo
    fun cambiarTamano(nuevolaBase: Int, nuevaAltura: Int){
        //this.base = nuevolaBase
        //this.altura = nuevaAltura
        dimensiones.ancho= nuevolaBase
        dimensiones.alto = nuevaAltura

    }

    // Método para cambiar el color del rectángulo
    fun cambiarColor(nuevoColor: Int){
       this.color = nuevoColor
    }
}