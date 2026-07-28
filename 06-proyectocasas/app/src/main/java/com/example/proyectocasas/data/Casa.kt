package com.example.proyectocasas.data

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import com.example.proyectocasas.R

data class Casa (val id: Int, val nombre: String, val imagenId: Int?, val imagenUri: Uri?, val descripcion: String)

object RepositorioCasas {
    val listaCasas = mutableStateListOf<Casa>(
        Casa(1, "Casa Mediterranea", R.drawable.casa1, null,"Casa luminosa frente al mar"),
        Casa(2, "Casa Rustica", R.drawable.casa2, null,"Ambiente calido en la montaña"),
        Casa(3, "Casa moderna", R.drawable.casa3, null,"Diseño minimalista y elegante"),
        Casa(4, "Casa sin foto", null, null,"Diseño minimalista y elegante"),
    )

    fun getCasaPorId (id: Int): Casa? = listaCasas.find { it.id == id }

    fun addCasa (nuevaCasa: Casa) = listaCasas.add(nuevaCasa)


}
