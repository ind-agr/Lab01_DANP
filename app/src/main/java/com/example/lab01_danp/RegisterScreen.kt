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



@OptIn(ExperimentalMaterial3Api::class)
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
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Nombre Completo")
            TextField(value = state.fullName, onValueChange = {
                onEvent(AsistenteEvent.SetFullName(it))
            })
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Fecha de Inscripción")
            TextField(value = state.dateInscription, onValueChange = {
                onEvent(AsistenteEvent.SetDateInscription(it))
            })
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Tipo de sangre")
            TextField(value = state.bloodType, onValueChange = {
                onEvent(AsistenteEvent.SetBloodType(it))
            })
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Teléfono")
            TextField(value = state.phone, onValueChange = {
                onEvent(AsistenteEvent.SetPhone(it))
            })
            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = "Monto Pagado")
            TextField(value = state.paidMount, onValueChange = {
                onEvent(AsistenteEvent.SetPaidMount(it))
            })

            Row {
                Button(
                    modifier = Modifier.padding(10.dp),
                    onClick = {
                        onEvent(AsistenteEvent.SaveAsistente)
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




