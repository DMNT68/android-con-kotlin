package com.example.proyectocasas.ui.pantallas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectocasas.ui.theme.ProyectocasasTheme

@Composable
fun PantallaInicio (navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bienvenido a la Galeria de Casas",
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineSmall
            )
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    navController.navigate("galeria")
                }
            ) {
                Text(text = "Ver Galería")
            }
            Button(
                onClick = {
                    navController.navigate("info")
                }
            ) {
                Text(text = "Sobre la app")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicioPreview() {
    ProyectocasasTheme(dynamicColor = false) {
        PantallaInicio(navController = rememberNavController())
    }
}