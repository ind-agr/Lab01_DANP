package com.example.lab01_danp

data class AsistenteState (
    val asistentes: List<Asistente> = emptyList(),
    val fullName: String = "",
    val dateInscription: String = "",
    val bloodType: String = "",
    val phone: String="",
    val paidMount: String = "",
    val isAddingAsistente: Boolean = false,
    val sortType: SortType =SortType.FULL_NAME
)