package com.example.myappbootcamp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myappbootcamp.databinding.ActivityRegisBinding
import kotlinx.coroutines.launch

class RegisActivity : AppCompatActivity() {
        lateinit var binding: ActivityRegisBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityRegisBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.btnRegis.setOnClickListener{
                sendDataToServer()
            }


            //lifecycleScope.launch{
                //val people = app.room.userDao().getAll()

        }

        private fun sendDataToServer() {
            if (validateForm()) {
                val db = Room.databaseBuilder(applicationContext,UserDatabase::class.java,"User_db").allowMainThreadQueries().build()
                val dao = db.userDao()
                val name = binding.etName.text.toString()
                val email = binding.etEmail.text.toString()
                val password = binding.etPassword.text.toString()

                lifecycleScope.launch{
                    val user = Usuario(email, name, password)
                    dao.insert(user)
                    val users = dao.getAll()
                    println(users)
                }

            }
        }

        private fun validateForm(): Boolean {
            var isValid = true

            with(binding) {
                if (etName.text.toString().isBlank()) {
                    isValid = false
                    tilName.error = "required"
                } else {
                    etName.error = null
                }
                return isValid
            }
        }
    }




