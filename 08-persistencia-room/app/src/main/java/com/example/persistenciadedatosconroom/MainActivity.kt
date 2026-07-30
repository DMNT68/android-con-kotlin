package com.example.persistenciadedatosconroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.persistenciadedatosconroom.ui.PantallaTareas
import com.example.persistenciadedatosconroom.ui.PantallaTareasContent
import com.example.persistenciadedatosconroom.ui.TareaViewModel
import com.example.persistenciadedatosconroom.ui.theme.PersistenciaDeDatosConRoomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Forma correcta de obtener el ViewModel con Application context
        val viewModel = ViewModelProvider(this)[TareaViewModel::class.java]
        
        enableEdgeToEdge()
        setContent {
            PersistenciaDeDatosConRoomTheme {
                TareasApp(viewModel)
            }
        }
    }
}

@Composable
fun TareasApp(viewModel: TareaViewModel) {
    PantallaTareas(viewModel)
}

@Preview(showBackground = true)
@Composable
fun TareasAppPreview() {
    PersistenciaDeDatosConRoomTheme {
        // En el preview usamos la versión sin estado (Stateless)
        PantallaTareasContent(
            lista = emptyList(),
            onAgregarTarea = {},
            onEliminarTarea = {},
            onActualizarTarea = {}
        )
    }
}