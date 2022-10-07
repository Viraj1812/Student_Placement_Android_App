package com.example.studentplacementandroidapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentplacementandroidapp.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponseOfStudentData: MutableLiveData<DBStudentDataResult> = MutableLiveData()
    val myResponseOfCompanyData: MutableLiveData<DBCompanyData> = MutableLiveData()
    val myResponseOfStudentSaveCompanyData: MutableLiveData<DBStudentDataResult> = MutableLiveData()
    val myResponseOfStudentSaveData: MutableLiveData<DBStudentDataResult> = MutableLiveData()

    fun getStudentData(uniqueToken : String){
        viewModelScope.launch {
            val response: DBStudentDataResult = repository.getStudentData()
            myResponseOfStudentData.value = response
        }
    }

    fun getCompanyData(){
        viewModelScope.launch {
            val response: DBCompanyData = repository.getCompanyData()
            myResponseOfCompanyData.value = response
        }
    }

    fun getStudentSaveCompanyData(uniqueToken : String){
        viewModelScope.launch {
            val response: DBStudentDataResult = repository.getStudentSaveCompanyData()
            myResponseOfStudentSaveCompanyData.value = response
        }
    }

    fun getStudentSaveData(){
        viewModelScope.launch {
            val response: DBStudentDataResult = repository.getStudentSaveData()
            myResponseOfStudentSaveData.value = response
        }
    }
}