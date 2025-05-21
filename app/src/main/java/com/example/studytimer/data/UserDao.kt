package com.example.studytimer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM User WHERE email = :email AND password = :password LIMIT 1")
    suspend fun getUser(email: String, password: String): User?
}
