package com.example.persistenciadedatosconroom.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.persistenciadedatosconroom.data.Tarea

@Composable
fun DialogUpdate(tarea: Tarea?, onDismiss: () -> Unit, onConfirm: () -> Unit, actualizarTarea: (String) -> Unit){

    var titulo by remember { mutableStateOf(tarea?.titulo ?: "") }
    var tituloTocado by remember { mutableStateOf(false) }

    Dialog (onDismissRequest = { onDismiss() }) {
        Card (
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Modificar el titulo de la tarea",
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge,

                )
                OutlinedTextField(
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .onFocusChanged { if (it.isFocused) tituloTocado = true },
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Nueva tarea") },
                    isError = tituloTocado && titulo.isBlank(),
                    supportingText = {
                        if (tituloTocado && titulo.isBlank()) {
                            Text("El nombre es obligatorio")
                        }
                    },
                )

                Row (
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                ) {
                    TextButton (
                        onClick = { onDismiss() },
                        modifier = Modifier.padding(end = 8.dp),
                    ) {
                        Text("Salir")
                    }
                    Button (
                        enabled = titulo.isNotBlank(),
                        onClick = {
                            if (titulo.isNotBlank()) {
                                actualizarTarea(titulo)
                                titulo = ""
                                tituloTocado = false
                            }
                            onConfirm() },
                    ) {
                        Text("Modificar")
                    }
                }
            }
        }
    }
}
