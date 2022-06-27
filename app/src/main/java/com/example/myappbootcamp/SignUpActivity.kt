package com.example.myappbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myappbootcamp.databinding.ActivitySignUpBinding
import kotlinx.coroutines.launch

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAccept.setOnClickListener {
            val db = connectDb() // base de datos conectada
            val data = getDataUser() //usuario
            addUserData(data, db)
            showUsersDb(db) //ver la base de datos en la consola
        }

        binding.btnBack.setOnClickListener {
            this.startActivity(Intent(this, MainActivity::class.java))

        }
    }


    private fun connectDb(): UserDao {
        val db = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "User_db")
            .allowMainThreadQueries().build()
        return db.userDao()
    }

    private fun getDataUser(): Usuario {
        val name = binding.etName.text.toString()
        val mail = binding.etMail.text.toString()
        val password = binding.etPassword.text.toString()
        return Usuario(mail, name, password)
    }

    private fun addUserData(user: Usuario, db: UserDao) {
        lifecycleScope.launch {
            db.insert(user)
            println(getString(R.string.user_registered))
        }
    }

    private fun showUsersDb(db: UserDao) {
        lifecycleScope.launch {
            val users = db.getAll()
            for (user in users) {
                println(user)
            }
        }
    }

}