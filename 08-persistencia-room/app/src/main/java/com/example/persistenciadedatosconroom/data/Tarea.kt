package com.example.persistenciadedatosconroom.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa una entidad de Tarea en la base de datos de Room.
 *
 * @property id Identificador único de la tarea (autogenerado).
 * @property titulo Título o nombre de la tarea.
 * @property descripcion Detalles adicionales sobre la tarea.
 * @property completada Estado que indica si la tarea ha sido finalizada.
 */
@Entity(tableName = "tareas")
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "titulo")
    val titulo: String,
    @ColumnInfo(name = "descripcion", defaultValue = "")
    val descripcion: String = "",
    @ColumnInfo(name = "completada", defaultValue = "false")
    val completada: Boolean = false
)