package com.example.studentplacementandroidapp.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat.finishAffinity
import com.example.studentplacementandroidapp.R
import com.example.studentplacementandroidapp.activity.EditProfileActivity
import com.example.studentplacementandroidapp.activity.LoginActivity
import com.example.studentplacementandroidapp.databinding.FragmentHomeBinding
import com.example.studentplacementandroidapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var _binding : FragmentProfileBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)

        binding.editProfile!!.setOnClickListener {
            val activity = activity as Context
            val intent = Intent(activity, EditProfileActivity::class.java)
            startActivity(intent)
        }

        binding.logout!!.setOnClickListener {
            callLogout(container!!.context)
        }

        return binding.root
    }

    private fun callLogout(context: Context) {
        activity?.let {
            AlertDialog.Builder(it)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Confirm"){ dialogInterface, i->
                    dialogInterface.cancel()
                    val activity = activity as Context
                    val intent = Intent(activity, LoginActivity::class.java)
                    intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                }
                .setNegativeButton("Cancel"){ dialogInterface, i->
                    dialogInterface.cancel()
                }
                .show()
        }
    }


    interface ProfileFragmentInterface{
        fun selectHomeTabFromProfileFragment(fragment: Fragment)
    }
}