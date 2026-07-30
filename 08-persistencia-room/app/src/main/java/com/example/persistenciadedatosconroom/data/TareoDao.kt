package com.example.persistenciadedatosconroom.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Objeto de Acceso a Datos (DAO) para la entidad [Tarea].
 * Proporciona métodos para interactuar con la tabla "tareas" en la base de datos.
 */
@Dao
interface TareoDao {

    /**
     * Recupera todas las tareas de la base de datos, ordenadas por ID de forma descendente.
     * @return Un [Flow] que emite una lista de objetos [Tarea] cada vez que cambian los datos.
     */
    @Query("SELECT * FROM tareas ORDER BY id DESC")
    fun obtenerTareas(): Flow<List<Tarea>>

    /**
     * Inserta una nueva tarea en la base de datos o la reemplaza si ya existe un conflicto.
     * @param tarea La [Tarea] que se va a insertar o actualizar.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(tarea: Tarea)

    /**
     * Elimina una tarea específica de la base de datos.
     * @param tarea La [Tarea] que se va a eliminar.
     */
    @Delete
    suspend fun eliminar(tarea: Tarea)

}
