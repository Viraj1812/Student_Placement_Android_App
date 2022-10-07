package com.example.studentplacementandroidapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.studentplacementandroidapp.R
import com.example.studentplacementandroidapp.databinding.FragmentHomeBinding
import com.example.studentplacementandroidapp.model.MainViewModel
import com.example.studentplacementandroidapp.model.MainViewModelFactory
import com.example.studentplacementandroidapp.repository.Repository


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel : MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        /*viewModel.getStudentSaveData()
        viewModel.myResponseOfStudentSaveData.observe(viewLifecycleOwner) {
            val x = it.firstName
            binding.studentName.text = x
        }*/

        return binding.root
    }
}