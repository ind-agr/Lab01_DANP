package com.example.lab01_danp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AsistenteViewModel(
    private val dao: AsistenteDao
): ViewModel() {

    private val _sortType = MutableStateFlow(SortType.FULL_NAME)
    private val _asistentes = _sortType
        .flatMapLatest { sortType ->
            when(sortType){
                SortType.FULL_NAME -> dao.getAsistentes()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


    private val _state = MutableStateFlow(AsistenteState())

    val state = combine(_state, _sortType, _asistentes){ state, sortType, asistentes ->
        state.copy(
            asistentes = asistentes,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AsistenteState())

    fun onEvent(event: AsistenteEvent){
        when(event){
            is AsistenteEvent.DeleteAsistant ->{
                viewModelScope.launch {
                    dao.deleteAsistente(event.asistente)
                }
            }
            AsistenteEvent.SaveAsistente -> {
                val fullName = state.value.fullName
                val dateInscription = state.value.dateInscription
                val bloodType = state.value.bloodType
                val phone = state.value.phone
                val paidMount = state.value.paidMount

                if(fullName.isBlank() || dateInscription.isBlank() || bloodType.isBlank() || phone.isBlank() || paidMount.isBlank()){
                    return
                }

                val asistente = Asistente(
                    fullName = fullName,
                    dateInscription = dateInscription,
                    bloodType = bloodType,
                    phone = phone,
                    paidMount = paidMount
                )
                viewModelScope.launch {
                    dao.insertAsistente(asistente)
                }
                _state.update { it.copy(
                    isAddingAsistente = false,
                    fullName = "",
                    dateInscription = "",
                    bloodType = "",
                    phone = "",
                    paidMount = ""
                    )                }
            }
            is AsistenteEvent.SetFullName -> {
                _state.update { it.copy(
                    fullName = event.fullName
                ) }
            }
            is AsistenteEvent.SetDateInscription -> {
                _state.update { it.copy(
                    dateInscription = event.dateInscription
                ) }
            }
            is AsistenteEvent.SetBloodType -> {
                _state.update { it.copy(
                    bloodType = event.bloodType
                ) }
            }
            is AsistenteEvent.SetPhone -> {
                _state.update { it.copy(
                    phone = event.phone
                ) }
            }
            is AsistenteEvent.SetPaidMount -> {
                _state.update { it.copy(
                    paidMount = event.paidMount
                ) }
            }

            is AsistenteEvent.SortAsistants -> {
                _sortType.value = event.sortType
            }


        }
    }
}