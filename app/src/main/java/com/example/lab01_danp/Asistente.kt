package com.example.lab01_danp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Asistente(
    @PrimaryKey(autoGenerate = true)

    val fullName: String,
    val dateInscription: String,
    val bloodType: String,
    val phone: String,
    val paidMount: String
)