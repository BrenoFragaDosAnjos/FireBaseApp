package com.example.firebaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebaseapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initListeners()
    }

    private fun initListeners() {
        with(binding){
            btnClick.setOnClickListener {
                throw java.lang.RuntimeException("Teste de crash do firebase")
            }
        }
    }
}