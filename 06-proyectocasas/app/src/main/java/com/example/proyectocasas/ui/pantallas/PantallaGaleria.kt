package com.example.proyectocasas.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectocasas.data.RepositorioCasas
import com.example.proyectocasas.ui.theme.ProyectocasasTheme

@Composable
fun PantallaGaleria (navController: NavController) {
    Scaffold (
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(innerPadding),
        ) {
            items(RepositorioCasas.listaCasas.size) { index: Int ->
                val casa = RepositorioCasas.listaCasas[index]
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.secondaryContainer
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clickable {
                            navController.navigate("detalle/${casa.id}")
                        }
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = painterResource(id = casa.imagenId),
                            contentDescription = casa.nombre,
                            modifier = Modifier.size(80.dp)
                        )
                        Spacer(modifier = Modifier.padding(end = 8.dp))
                        Column {
                            Text(text = casa.nombre, style = MaterialTheme.typography.titleMedium)
                            Text(text = casa.descripcion, maxLines = 2)
                        }

                    }
                }

            }
            item {
                Button(
                    modifier = Modifier.padding(top = 24.dp).fillMaxWidth(),
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Text(text = "Volver al inicio")
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PantallaGaleriaPreview() {
    ProyectocasasTheme(dynamicColor = false) {
        PantallaGaleria(navController = rememberNavController())
    }
}