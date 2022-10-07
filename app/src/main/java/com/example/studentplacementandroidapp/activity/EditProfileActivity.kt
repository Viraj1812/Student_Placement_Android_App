package com.example.studentplacementandroidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.studentplacementandroidapp.databinding.ActivityEditProfileBinding
import com.example.studentplacementandroidapp.fragment.ProfileFragment

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.llNext1.setOnClickListener{
            binding.llRegistrationForm1.visibility = View.GONE
            binding.llNext1.visibility = View.GONE
            binding.llRegistrationForm2.visibility = View.VISIBLE
            binding.llNext2.visibility = View.VISIBLE
        }

        binding.llNext2.setOnClickListener{
            val intent = Intent(this@EditProfileActivity,MainActivity::class.java)
            startActivity(intent)

        }
    }
}