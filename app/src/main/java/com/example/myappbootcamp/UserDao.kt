package com.example.myappbootcamp

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Query("SELECT * FROM Usuario")
    suspend fun getAll(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE email = :email")
    suspend fun getByEmail(email: String):Usuario

     @Update
    suspend fun update(User: Usuario)

    @Insert
    suspend fun insert(User: Usuario)

    @Delete
    suspend fun delete(User: Usuario)

    @Query("SELECT * FROM Usuario WHERE email=:email AND password=:password")
    fun getUserByEmailPassword(email:String, password:String):Usuario


}