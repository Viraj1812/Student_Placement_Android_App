package com.example.studentplacementandroidapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studentplacementandroidapp.R
import com.example.studentplacementandroidapp.databinding.ActivityEditProfileBinding
import com.example.studentplacementandroidapp.databinding.ActivityMainBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}