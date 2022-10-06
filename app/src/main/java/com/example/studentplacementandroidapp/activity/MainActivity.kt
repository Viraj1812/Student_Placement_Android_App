package com.example.studentplacementandroidapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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

    override fun onBackPressed() {
        showExitAlertDialog()
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

    private fun showExitAlertDialog() {
        val alertDialog: AlertDialog.Builder = AlertDialog.Builder(this, R.style.AlertDialogCustom)
        alertDialog.setCancelable(false)
        alertDialog.setTitle(resources.getString(R.string.app_name))
        alertDialog.setMessage(resources.getString(R.string.exit_msg))

        alertDialog.setPositiveButton(
            resources.getString(R.string.exit)
        ) { p0, p1 ->
            finishAffinity()
        }
        alertDialog.setNegativeButton(
            resources.getString(R.string.cancel)
        ) { p0, p1 ->
            p0?.dismiss()
        }

        alertDialog.show()
    }
}