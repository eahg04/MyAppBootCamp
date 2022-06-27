package com.example.myappbootcamp

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.myappbootcamp.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            if (binding.boxUser.text.isEmpty() || binding.boxPassWord.text.isEmpty()) {
                Toast.makeText(this, getString(R.string.fields_empty), Toast.LENGTH_SHORT).show()
            } else {
                val db = connectDb()
                val access = accessUser(db)
                if (access != null) {
                    startActivity(Intent(this, HomeActivity::class.java))
                } else {

                    println(getString(R.string.user_no_found))
                    Toast.makeText(this, getString(R.string.user_not_found), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))

        }
    }

    private fun connectDb(): UserDao {
        val db = Room.databaseBuilder(applicationContext, UserDatabase::class.java, "User_db")
            .allowMainThreadQueries().build()
        return db.userDao()
    }


    private fun accessUser(db: UserDao): Usuario {
        val user = binding.boxUser.text.toString()
        val password = binding.boxPassWord.text.toString()
        return db.getUserByEmailPassword(user, password)
    }


}











