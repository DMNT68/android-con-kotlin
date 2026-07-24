package com.example.proyectocasas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectocasas.ui.pantallas.PantallaDetalle
import com.example.proyectocasas.ui.pantallas.PantallaGaleria
import com.example.proyectocasas.ui.pantallas.PantallaInfo
import com.example.proyectocasas.ui.pantallas.PantallaInicio
import com.example.proyectocasas.ui.pantallas.PantallaFomulario
import com.example.proyectocasas.ui.theme.ProyectocasasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectocasasTheme(dynamicColor = false) {
                CasaApp()
            }
        }
    }
}

@Composable
fun CasaApp() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(navController, startDestination = "inicio") {
            composable("inicio") { PantallaInicio(navController) }
            composable("info") { PantallaInfo(navController) }
            composable("galeria") { PantallaGaleria(navController) }
            // Ejemplo en el NavHost
            composable("detalle/{casaId}") { backStackEntry ->
                val casaId = backStackEntry.arguments?.getString("casaId")
                PantallaDetalle(casaId?.toInt() ?: 0, navController)
            }
            composable("formulario") { PantallaFomulario(navController) }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun CasaAppPreview() {
    ProyectocasasTheme(dynamicColor = false) {
        CasaApp()
    }
}
