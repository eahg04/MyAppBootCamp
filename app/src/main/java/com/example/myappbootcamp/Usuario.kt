package com.example.myappbootcamp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario(
    @PrimaryKey()
    val email: String,
    val usuario: String,
    val password: String

)