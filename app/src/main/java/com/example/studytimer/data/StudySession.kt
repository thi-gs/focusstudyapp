package com.example.studytimer.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudySession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val duration: Long,
    val timestamp: Long,
    val userId: Int
)
