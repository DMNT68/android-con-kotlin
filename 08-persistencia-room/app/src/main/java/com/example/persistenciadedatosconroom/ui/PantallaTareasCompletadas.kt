package com.example.persistenciadedatosconroom.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.persistenciadedatosconroom.R
import com.example.persistenciadedatosconroom.data.Tarea
import com.example.persistenciadedatosconroom.ui.theme.PersistenciaDeDatosConRoomTheme

@Composable
fun PantallaTareasCompletadas (viewModel: TareaViewModel) {
    val lista by viewModel.tareas.collectAsState(initial = emptyList())

    PantallaTareasCompletadasContent(
        lista = lista.filter { tarea -> tarea.completada },
        onEliminarTarea = { viewModel.eliminarTarea(it) },
        onActualizarTarea = { viewModel.actualizarTarea(it) }
    )
}

@Composable
fun PantallaTareasCompletadasContent(
    lista: List<Tarea>,
    onEliminarTarea: (Tarea) -> Unit,
    onActualizarTarea: (Tarea) -> Unit
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(vertical = 8.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                Text(
                    "Lista de tareas completadas vacia",
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
        PantallaTareasCompletadasContent(
            lista = listOf(
//                Tarea(1, "Tarea 1", completada = false),
//                Tarea(2, "Tarea 2", completada = false)
            ),
            onEliminarTarea = {},
            onActualizarTarea = {}
        )
    }
}