package com.example.studentplacementandroidapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentplacementandroidapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val myResponseOfStudentData: MutableLiveData<DBStudentDataResult> = MutableLiveData()
    private val myResponseOfCompanyData: MutableLiveData<DBStudentDataResult> = MutableLiveData()
    private val myResponseOfStudentSaveCompanyData: MutableLiveData<DBStudentDataResult> = MutableLiveData()

    fun getStudentData(uniqueToken : String){
        viewModelScope.launch {
            val response: DBStudentDataResult = repository.getStudentData()
            myResponseOfStudentData.value = response
        }
    }

    fun getCompanyData(){
        viewModelScope.launch {
            val response: DBStudentDataResult = repository.getStudentData()
            myResponseOfCompanyData.value = response
        }
    }

    fun getStudentSaveCompanyData(uniqueToken : String){
        viewModelScope.launch {
            val response: DBStudentDataResult = repository.getStudentData()
            myResponseOfStudentSaveCompanyData.value = response
        }
    }

}