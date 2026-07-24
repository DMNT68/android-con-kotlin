package com.example.proyectocasas.data

import com.example.proyectocasas.R

data class Casa (val id: Int, val nombre: String, val imagenId: Int, val descripcion: String)

object RepositorioCasas {
    val listaCasas = listOf(
        Casa(1, "Casa Mediterranea", R.drawable.casa1, "Casa luminosa frente al mar"),
        Casa(2, "Casa Rustica", R.drawable.casa2, "Ambiente calido en la montaña"),
        Casa(3, "Casa moderna", R.drawable.casa3, "Diseño minimalista y elegante"),
        Casa(4, "Villa Soleada", R.drawable.casa1, "Espaciosa villa con piscina"),
        Casa(5, "Refugio Alpino", R.drawable.casa2, "Cabaña de madera con chimenea"),
        Casa(6, "Loft Urbano", R.drawable.casa3, "Apartamento de lujo en el centro"),
        Casa(7, "Bungalow Tropical", R.drawable.casa1, "Rodeado de vegetación exuberante"),
        Casa(8, "Cabaña del Bosque", R.drawable.casa2, "Perfecta para desconectar"),
        Casa(9, "Mansión Minimalista", R.drawable.casa3, "Vistas panorámicas a la ciudad"),
        Casa(10, "Residencia Costera", R.drawable.casa1, "Acceso directo a la playa"),
        Casa(11, "Chalet de Piedra", R.drawable.casa2, "Arquitectura tradicional y acogedora"),
        Casa(12, "Penthouse de Cristal", R.drawable.casa3, "Estructura innovadora y luminosa"),
        Casa(13, "Cortijo Andaluz", R.drawable.casa1, "Patio central y estilo clásico")
    )

    fun getCasaPorId (id: Int): Casa? = listaCasas.find { it.id == id }

}
