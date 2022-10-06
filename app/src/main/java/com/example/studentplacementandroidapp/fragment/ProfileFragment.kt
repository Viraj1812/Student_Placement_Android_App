package com.example.studentplacementandroidapp.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
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
            val activity = activity as Context
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


    interface ProfileFragmentInterface{
        fun selectHomeTabFromProfileFragment(fragment: Fragment)
    }
}