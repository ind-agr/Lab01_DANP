package com.example.lab01_danp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun RegisterScreen(
    state: AsistenteState,
    onEvent : (AsistenteEvent)->Unit
){
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(25.dp)
        ) {
            nombreField()
            fechaField()
            sangreField()
            telefonoField()
            montoField()

            Row {
                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {

                    }) {
                    Text("Registrar")
                }
                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {

                    }) {
                    Text(text = "Cancelar")
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun nombreField(){
    Text(
        modifier = Modifier.padding(top = 5.dp),
        text = "Nombre Completo")
    TextField(value = "", onValueChange = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fechaField(){
    Text(
        modifier = Modifier.padding(top = 5.dp),
        text = "Fecha de Inscripción")
    TextField(value = "", onValueChange = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun sangreField(){
    Text(
        modifier = Modifier.padding(top = 5.dp),
        text = "Tipo de sangre")
    TextField(value = "", onValueChange = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun telefonoField(){
    Text(
        modifier = Modifier.padding(top = 5.dp),
        text = "Teléfono")
    TextField(value = "", onValueChange = {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun montoField(){
    Text(
        modifier = Modifier.padding(top = 5.dp),
        text = "Monto Pagado")
    TextField(value = "", onValueChange = {})
}



