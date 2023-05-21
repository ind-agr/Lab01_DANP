package com.example.lab01_danp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AsistenteDao {
    @Upsert
    suspend fun insertAsistente(asistente: Asistente)

    @Delete
    suspend fun deleteAsistente(asistente: Asistente)

    @Query("SELECT * FROM asistente ORDER BY fullName ASC")
    fun getAsistentes(): Flow<List<Asistente>>
}