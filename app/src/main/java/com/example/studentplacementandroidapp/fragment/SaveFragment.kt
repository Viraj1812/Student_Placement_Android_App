package com.example.studentplacementandroidapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.studentplacementandroidapp.R
import com.example.studentplacementandroidapp.databinding.FragmentHomeBinding
import com.example.studentplacementandroidapp.databinding.FragmentSaveBinding
import com.example.studentplacementandroidapp.model.MainViewModel
import com.example.studentplacementandroidapp.model.MainViewModelFactory
import com.example.studentplacementandroidapp.repository.Repository

class SaveFragment : Fragment() {

    private var _binding : FragmentSaveBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSaveBinding.inflate(inflater, container, false)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        return binding.root
    }
}