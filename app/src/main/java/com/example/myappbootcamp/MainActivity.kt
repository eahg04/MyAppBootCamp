package com.example.myappbootcamp

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.myappbootcamp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
        private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, HomeActivity::class.java))
        }



        binding.txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisActivity::class.java))

        }
    }

}









