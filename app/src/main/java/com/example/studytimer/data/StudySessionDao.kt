package com.example.studytimer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StudySessionDao {
    @Insert
    suspend fun insert(session: StudySession)

    @Query("SELECT * FROM StudySession WHERE userId = :userId ORDER BY timestamp DESC")
    suspend fun getAllSessionsForUser(userId: Int): List<StudySession>
}
