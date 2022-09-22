package com.example.studentplacementandroidapp

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.studentplacementandroidapp.databaseConnection.Database


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Database()

    }
}