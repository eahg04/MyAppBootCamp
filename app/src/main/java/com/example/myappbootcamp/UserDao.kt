package com.example.myappbootcamp

import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM Usuario")
    suspend fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE email = :email")
    suspend fun getByEmail(email:String):Usuario

    @Insert
    suspend fun insert(User:Usuario)



}