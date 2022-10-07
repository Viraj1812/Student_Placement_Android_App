package com.example.studentplacementandroidapp.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentplacementandroidapp.adapter.CompanyDataAdapter
import com.example.studentplacementandroidapp.databinding.FragmentHomeBinding
import com.example.studentplacementandroidapp.model.MainViewModel
import com.example.studentplacementandroidapp.model.MainViewModelFactory
import com.example.studentplacementandroidapp.repository.Repository


class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var viewModel : MainViewModel
    private lateinit var rvAdapter: CompanyDataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getCompanyData()
        viewModel.myResponseOfCompanyData.observe(viewLifecycleOwner) {response->

            binding.CDRv.layoutManager = LinearLayoutManager(container!!.context)
            val updateList = response.openings.rows
            rvAdapter = CompanyDataAdapter(container.context,updateList)
            binding.CDRv.adapter = rvAdapter

        }

        return binding.root
    }
}