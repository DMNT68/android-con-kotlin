package com.example.persistenciadedatosconroom.data

import android.content.Context
import androidx.room.RoomDatabase
import androidx.room.Room
import androidx.room.Database

/**
 * Base de datos de Room para la aplicación.
 * Define las entidades y proporciona acceso a los DAOs.
 */
@Database(entities = [Tarea::class], version = 1, exportSchema = false)
abstract class TareaDatabase : RoomDatabase() {

    /**
     * Obtiene el DAO para interactuar con la tabla de tareas.
     */
    abstract fun tareaDao(): TareoDao

    companion object {
        @Volatile
        private var INSTANCIA: TareaDatabase? = null

        /**
         * Obtiene la instancia única de la base de datos (Singleton).
         * Si no existe, la crea utilizando Room.databaseBuilder.
         *
         * @param context El contexto de la aplicación.
         * @return La instancia de [TareaDatabase].
         */
        fun getDatabase(context: Context): TareaDatabase {
            return INSTANCIA ?: synchronized(this) {
                val instancia = Room.databaseBuilder(
                    context.applicationContext,
                    TareaDatabase::class.java,
                    "tarea_database"
                ).build()
                INSTANCIA = instancia
                instancia
            }
        }
    }
}
