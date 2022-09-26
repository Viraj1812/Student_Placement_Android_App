package com.example.studentplacementandroidapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentplacementandroidapp.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}