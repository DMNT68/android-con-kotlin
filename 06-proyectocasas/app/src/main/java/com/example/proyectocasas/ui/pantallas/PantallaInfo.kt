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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectocasas.ui.theme.ProyectocasasTheme

@Composable
fun PantallaInfo (navController: NavController) {
    Scaffold (
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = "Volver")
            }
            Text(
                text = "Desarollado por pildoras informaticas",
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = "App de ejemplo creada para enseñar Navigation en Jetpack Compose",
                fontSize = 16.sp,
                style = MaterialTheme.typography.headlineSmall
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInfoPreview() {
    ProyectocasasTheme(dynamicColor = false) {
        PantallaInfo(navController = rememberNavController())
    }
}
