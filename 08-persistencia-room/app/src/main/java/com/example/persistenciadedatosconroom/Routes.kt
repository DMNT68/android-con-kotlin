package com.example.persistenciadedatosconroom

sealed class Route(val ruta: String, val titulo: String, val icono: Int) {
    object Pendientes : Route("pendientes", "Por hacer", R.drawable.ic_check_blank)
    object Completadas : Route("completadas", "Hechas", R.drawable.ic_check)
}