package com.example.proyectocasas.ui.pantallas

import android.R
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil3.compose.rememberAsyncImagePainter
import com.example.proyectocasas.ui.theme.ProyectocasasTheme


@Composable
fun PantallaFomulario (navController: NavController){
    val focusManager = LocalFocusManager.current
    val nombreState = rememberTextFieldState()
    val descripcionState = rememberTextFieldState()
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // Launcher del selector de imágenes
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) {
        uri: Uri? -> imageUri = uri
    }

    var nombreTocado by remember { mutableStateOf(false) }
    var descripcionTocado by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Text(
                text = "Registro de una nueva casa",
                fontSize = 20.sp,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Column (modifier = Modifier
                .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
                ){

                OutlinedTextField(
                    state = nombreState,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                    onKeyboardAction = { focusManager.moveFocus(FocusDirection.Next) },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .onFocusChanged { if (it.isFocused) nombreTocado = true },
                    label = {Text("Nombre de la casa")},
                    isError = nombreTocado && nombreState.text.isBlank(),
                    supportingText = {
                        if (nombreTocado && nombreState.text.isBlank()) {
                            Text("El nombre es obligatorio")
                        }
                    },
                )
                OutlinedTextField(
                    state = descripcionState,
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        imeAction = ImeAction.Done
                    ),
                    onKeyboardAction = { focusManager.clearFocus() },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .onFocusChanged { if (it.isFocused) descripcionTocado = true },
                    label = {Text("Descripción de la casa")},
                    isError = descripcionTocado && descripcionState.text.length < 10,
                    supportingText = {
                        if (descripcionTocado && descripcionState.text.length < 10) {
                            Text("La descripción debe tener al menos 10 caracteres")
                        }
                    },
                    lineLimits = TextFieldLineLimits.MultiLine(
                        minHeightInLines = 3, // Altura mínima inicial
                        maxHeightInLines = 5  // Altura máxima antes de hacer scroll
                    )
                )

                imageUri?.let{
                    Image(
                        painter = rememberAsyncImagePainter(it ),
                        contentDescription = "Imagen seleccionada",
                        modifier = Modifier.fillMaxWidth().height(200.dp)
                    )
                }

                OutlinedButton(
                    modifier = Modifier
                        .padding(bottom = 16.dp),
                    onClick = { launcher.launch("image/*") }
                ){
                    Text(text = "Seleccionar imagen")
                }

                Button(
                    enabled = nombreState.text.isNotBlank() && descripcionState.text.length >= 10,
                    modifier = Modifier.width(150.dp),
                    onClick = {
                        nombreTocado = true
                        descripcionTocado = true
                        if(nombreState.text.isNotBlank() && descripcionState.text.length >= 10){
                            navController.popBackStack()
                        }
                    }
                ){
                    Text(text = "Guardar")
                }
                TextButton (
                    modifier = Modifier.width(150.dp),
                    onClick = {navController.popBackStack()}
                ){
                    Text(text = "Volver")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaFormularioPreview() {
    ProyectocasasTheme(dynamicColor = false) {
        PantallaFomulario(navController = rememberNavController())
    }
}