package com.example.lab01_danp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class RegisterViewModel: ViewModel() {
    var nombreCompleto by mutableStateOf("")
    var fechaInscripcion by mutableStateOf("")
    var tipoSangre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var montoPagado by mutableStateOf("")
    fun register(){
        viewModelScope.launch(Dispatchers.IO) {

        }
    }
    fun cancel(){

    }
}