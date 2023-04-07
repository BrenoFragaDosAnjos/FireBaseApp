package com.example.firebaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseapp.databinding.ActivitySplashScreenBinding

class FirstScreen : AppCompatActivity() {
    private val binding : ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        with(binding){
            buttonLogar.setOnClickListener { startActivity(Intent(this@FirstScreen,LoginActivity::class.java)) }
            buttonCadastrar.setOnClickListener { startActivity(Intent(this@FirstScreen,CadastroActivity::class.java)) }
        }
    }
}