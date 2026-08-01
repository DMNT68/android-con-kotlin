package com.example.persistenciadedatosconroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.persistenciadedatosconroom.ui.PantallaTareas
import com.example.persistenciadedatosconroom.ui.PantallaTareasCompletadas
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
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                // Botón para Pendientes
                NavigationBarItem(
                    selected = currentRoute == Route.Pendientes.ruta,
                    onClick = { navController.navigate(Route.Pendientes.ruta) },
                    icon = { Icon(painterResource(Route.Pendientes.icono), contentDescription = null) },
                    label = { Text(Route.Pendientes.titulo) }
                )

                // Botón para Completadas
                NavigationBarItem(
                    selected = currentRoute == Route.Completadas.ruta,
                    onClick = { navController.navigate(Route.Completadas.ruta) },
                    icon = { Icon(painterResource(Route.Completadas.icono), contentDescription = null) },
                    label = { Text(Route.Completadas.titulo) }
                )
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Route.Pendientes.ruta, modifier = Modifier.padding(innerPadding)) {
            composable (Route.Pendientes.ruta) {
                PantallaTareas(viewModel)
            }
            composable(Route.Completadas.ruta) {
                PantallaTareasCompletadas(viewModel)
            }
        }
    }

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