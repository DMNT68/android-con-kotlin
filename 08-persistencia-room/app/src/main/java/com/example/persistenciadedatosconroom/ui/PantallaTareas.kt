package com.example.persistenciadedatosconroom.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.persistenciadedatosconroom.R
import com.example.persistenciadedatosconroom.data.Tarea
import com.example.persistenciadedatosconroom.ui.theme.PersistenciaDeDatosConRoomTheme

@Composable
fun PantallaTareas(viewModel: TareaViewModel) {
    val lista by viewModel.tareas.collectAsState(initial = emptyList())
    
    PantallaTareasContent(
        lista = lista,
        onAgregarTarea = { viewModel.agregarTareas(it) },
        onEliminarTarea = { viewModel.eliminarTarea(it) },
        onActualizarTarea = { viewModel.actualizarTarea(it) }
    )
}

@Composable
fun PantallaTareasContent(
    lista: List<Tarea>,
    onAgregarTarea: (String) -> Unit,
    onEliminarTarea: (Tarea) -> Unit,
    onActualizarTarea: (Tarea) -> Unit
) {
    var texto by remember { mutableStateOf("") }
    var textoTocado by remember { mutableStateOf(false) }

    Scaffold(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .onFocusChanged { if (it.isFocused) textoTocado = true },
                value = texto,
                onValueChange = { texto = it },
                label = { Text("Nueva tarea") },
                isError = textoTocado && texto.isBlank(),
                supportingText = {
                    if (textoTocado && texto.isBlank()) {
                        Text("El nombre es obligatorio")
                    }
                },
            )
            Button(
                enabled = texto.isNotBlank(),
                modifier = Modifier.
                    fillMaxWidth().
                    padding(bottom = 8.dp),
                onClick = {
                    if (texto.isNotBlank()) {
                        onAgregarTarea(texto)
                        texto = ""
                        textoTocado = false
                    }
                }
            ) {
                Text("Añadir tarea")
            }
            if(lista.isNotEmpty()){
                LazyColumn(modifier = Modifier
                    .fillMaxSize()
                ) {
                    items(lista) { tarea ->
                        Card(modifier = Modifier
                            .fillMaxWidth().
                            padding(bottom = 8.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                IconButton(onClick = {
                                    onActualizarTarea(tarea.copy(completada = !tarea.completada))
                                }) {
                                    Icon(
                                        painter = painterResource(id = if (tarea.completada) R.drawable.ic_check else R.drawable.ic_check_blank),
                                        contentDescription = "Eliminar"
                                    )
                                }
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(tarea.titulo, modifier = Modifier.padding(16.dp))
                                }
                                Column() {
                                    Row() {
                                        IconButton(onClick = { onEliminarTarea(tarea) }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_delete),
                                                contentDescription = "Eliminar"
                                            )
                                        }
                                        IconButton(onClick = { /* TODO: Implement modify */ }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.ic_edit),
                                                contentDescription = "Modificar"
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                Text(
                    "Lista de tareas vacia",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PersistenciaDeDatosConRoomTheme {
        PantallaTareasContent(
            lista = listOf(
                Tarea(1, "Tarea 1")
            ),
            onAgregarTarea = {},
            onEliminarTarea = {},
            onActualizarTarea = {}
        )
    }
}