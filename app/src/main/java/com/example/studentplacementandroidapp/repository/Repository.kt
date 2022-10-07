package com.example.studentplacementandroidapp.repository

import com.example.studentplacementandroidapp.api.RetrofitInstance
import com.example.studentplacementandroidapp.model.DBCompanyData
import com.example.studentplacementandroidapp.model.DBStudentDataResult
import retrofit2.http.Query

class Repository {

    suspend fun getStudentData() : DBStudentDataResult{
        return RetrofitInstance.api.getStudentData()
    }

    suspend fun getCompanyData() : DBCompanyData {
        return RetrofitInstance.api.getCompanyData()
    }

    suspend fun getStudentSaveCompanyData() : DBStudentDataResult{
        return RetrofitInstance.api.getStudentSaveCompanyData()
    }

    suspend fun getStudentSaveData() : DBStudentDataResult{
        return RetrofitInstance.api.getStudentSaveData()
    }


}