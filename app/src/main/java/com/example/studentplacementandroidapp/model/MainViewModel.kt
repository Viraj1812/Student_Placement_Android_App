package com.example.studentplacementandroidapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studentplacementandroidapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myResponseOfRegisterStudent: MutableLiveData<Response<DBStudentDataResult>> = MutableLiveData()
    val myResponseOfEditedStudent: MutableLiveData<Response<DBEditedStudentDataResult>> = MutableLiveData()
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

    fun pushPost(post:DBStudentDataResult){
        viewModelScope.launch {
            val response  = repository.pushPost(post)
            myResponseOfRegisterStudent.value = response
        }
    }

    fun pushEditPost(post:DBEditedStudentDataResult){
        viewModelScope.launch {
            val response  = repository.pushEditPost(post)
            myResponseOfEditedStudent.value = response
        }
    }
}