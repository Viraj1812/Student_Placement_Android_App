package com.example.studentplacementandroidapp.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.studentplacementandroidapp.databinding.RvTempLayoutBinding
import com.example.studentplacementandroidapp.model.Row

class CompanyDataAdapter(
    val context: Context,
    private var CData: List<Row>
):
    RecyclerView.Adapter<CompanyDataAdapter.CompanyDataViewHolder>(){

    inner class CompanyDataViewHolder(val binding : RvTempLayoutBinding ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyDataViewHolder {
        val view = RvTempLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompanyDataViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: CompanyDataViewHolder, position: Int) {
        with(holder) {
            with(CData[position]) {
                binding.Date.text = CData[position].posted_at.toString()
                binding.role.text = CData[position].role
                binding.companyName.text = CData[position].company_name
                binding.location.text = CData[position].location
            }
        }
    }

    override fun getItemCount(): Int {
        return CData.size
    }

}