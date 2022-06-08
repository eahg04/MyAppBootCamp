package com.example.myappbootcamp

import android.app.Application
import androidx.room.Room

class PersonApp : Application() {
    val room = Room.databaseBuilder(this,UserDatabase::class.java,"Usuarios").build()
}