package com.example.studentplacementandroidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.studentplacementandroidapp.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.llNext1.setOnClickListener{
            binding.llRegistrationForm1.visibility = GONE
            binding.llNext1.visibility = GONE
            binding.llRegistrationForm2.visibility = VISIBLE
            binding.llNext2.visibility = VISIBLE
        }

        binding.llNext2.setOnClickListener{
            val intent = Intent(this@RegistrationActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
}