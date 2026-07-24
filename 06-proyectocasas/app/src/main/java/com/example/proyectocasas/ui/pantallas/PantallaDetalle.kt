package com.example.proyectocasas.ui.pantallas

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.proyectocasas.data.RepositorioCasas
import com.example.proyectocasas.ui.theme.ProyectocasasTheme

@Composable
fun PantallaDetalle (casaId: Int, navController: NavController) {
    val casa = RepositorioCasas.getCasaPorId(casaId)

    val colorPorDefecto = MaterialTheme.colorScheme.background
    var colorFondo by remember { mutableStateOf(colorPorDefecto) }

    var escala by remember { mutableStateOf(1f) }
    val escalaAnimada by animateFloatAsState(targetValue = escala, animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing))

    if (casa == null) {
        CasaNoEncontrada(navController = navController)
        return
    }

    Scaffold(
        containerColor = colorFondo,
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
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
                text = casa.nombre ,
                modifier = Modifier.padding(bottom = 16.dp).align(alignment = Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineSmall
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .pointerInput(Unit) {
                        detectTransformGestures { _, _, zoom, _ ->
                            escala *= zoom
                        }
                    }.pointerInput(Unit){
                        detectTapGestures(
                            onDoubleTap = {
                                escala = 1f
                            }
                        )
                    },

            ) {
                Image(
                    painter = painterResource(id = casa.imagenId ),
                    contentDescription = casa.nombre,
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer(
                            scaleX = escalaAnimada.coerceIn(0.5f,3f), // Limitar el zoom eje x
                            scaleY = escalaAnimada.coerceIn(0.5f,3f), // Limitar el zoom eje y
                        ),
                )
            }
            Text(
                text = casa.descripcion ,
                modifier = Modifier.padding(bottom = 16.dp),
            )
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    colorFondo = colorAleatorio()
                }
            ) {
                Text(text = "Cambiar fondo")
            }
        }
    }
}

fun colorAleatorio(): Color{
    return Color(
        red = (0..255).random(),
        green = (0..255).random(),
        blue = (0..255).random()
    )
}

@Composable
fun CasaNoEncontrada(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Casa no encontrada",
                modifier = Modifier.padding(bottom = 16.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineSmall
            )

            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text(text = "Volver")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CasaAppPreview() {
    ProyectocasasTheme(dynamicColor = false) {
        PantallaDetalle(1, navController = rememberNavController())
    }
}