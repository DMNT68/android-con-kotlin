package com.andres_sagadoc.jetpackpruebas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andres_sagadoc.jetpackpruebas.ui.theme.JetPackPruebasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackPruebasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LayoutPrincipal(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun LayoutPrincipal(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize().padding(horizontal = 40.dp), contentAlignment = Alignment.Center) {
        Column (modifier = modifier.fillMaxWidth()){
            // Bandera()
                Text(
                    text = "Login",
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(bottom = 16.dp),
                )
            Formulario(modifier)
        }
    }

}

@Composable
fun Formulario (modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(modifier = modifier.fillMaxWidth().padding(WindowInsets.ime.asPaddingValues()), horizontalAlignment = Alignment.CenterHorizontally){
        val context = LocalContext.current
        TextField(
            modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            },
            singleLine = true,
            placeholder = { Text(text = "Ingrese su correo electrónico") },
            label = { Text(text = "Correo electrónico") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth(),
            value = password,
            singleLine = true,
            onValueChange = { newText ->
                password = newText
                println(password)
            },
            placeholder = { Text(text = "Ingrese su contraseña") },
            label = { Text(text = "Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Button(
            modifier = Modifier.padding(vertical = 8.dp),
            onClick = {
                Toast.makeText(
                    context,
                    "Haz iniciado sesión con $email y $password",
                    Toast.LENGTH_SHORT
                ).show()
            }
        ) {
            Text(text = "Iniciar sesión")
        }
    }
}

@Composable
fun SimpleFilledTextFieldSample() {
    var text by remember { mutableStateOf("Hello") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}

@Composable
fun Bandera (modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Franja(color = Color.Yellow, name = "", padding = 32)
        Franja(color = Color.Blue, name = "", padding = 24)
        Franja(color = Color.Red, name = "", padding = 16)
    }
}

@Composable
fun Franja ( name: String = "", color: Color, padding: Int = 24, modifier: Modifier = Modifier) {
    Surface(color = color, modifier = modifier.width(300.dp)) {
        Text(
            text = "$name",
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            modifier = modifier.padding(padding.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetPackPruebasTheme {
        LayoutPrincipal()
    }
}
