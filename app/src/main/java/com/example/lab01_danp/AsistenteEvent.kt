package com.example.lab01_danp

sealed interface AsistenteEvent{


    object SaveAsistente: AsistenteEvent
    data class SetFullName(val fullName: String): AsistenteEvent
    data class SetDateInscription(val dateInscription: String): AsistenteEvent
    data class SetBloodType(val bloodType: String): AsistenteEvent
    data class SetPhone(val phone: String): AsistenteEvent
    data class SetPaidMount(val paidMount: String): AsistenteEvent
    data class SortAsistants(val sortType: SortType) : AsistenteEvent
    data class DeleteAsistant(val asistente: Asistente): AsistenteEvent
}