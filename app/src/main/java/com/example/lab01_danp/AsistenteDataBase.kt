package com.example.lab01_danp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Asistente::class],
    version = 1
)
abstract class AsistenteDataBase: RoomDatabase() {
    abstract val dao : AsistenteDao
}