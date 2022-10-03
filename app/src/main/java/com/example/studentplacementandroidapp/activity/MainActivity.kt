package com.example.studentplacementandroidapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.studentplacementandroidapp.R
import com.example.studentplacementandroidapp.databaseConnection.Database
import com.example.studentplacementandroidapp.databinding.ActivityMainBinding
import com.example.studentplacementandroidapp.fragment.HomeFragment
import com.example.studentplacementandroidapp.fragment.ProfileFragment
import com.example.studentplacementandroidapp.fragment.SaveFragment


class MainActivity : AppCompatActivity(), ProfileFragment.ProfileFragmentInterface {

    private lateinit var binding: ActivityMainBinding
    private var fragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {

            loadFragment(HomeFragment())

            bottomNavigation.onItemSelected = {
                when (it) {
                    0 -> {
                        fragment = HomeFragment()
                    }
                    1 -> {
                        fragment = SaveFragment()
                    }
                    2 -> {
                        fragment = ProfileFragment()
                    }
                }
                loadFragment(fragment)
            }

            bottomNavigation.onItemReselected = {
            }
        }

    }

    private fun loadFragment(fragment: Fragment?) {
        fragment?.let {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fL, it)
                .commit()
        }
    }

    override fun selectHomeTabFromProfileFragment(fragment: Fragment) {
        binding.bottomNavigation.itemActiveIndex = 0
        loadFragment(fragment)
    }
}