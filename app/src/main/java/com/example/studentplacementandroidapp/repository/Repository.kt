package com.example.studentplacementandroidapp.repository

import com.example.studentplacementandroidapp.api.RetrofitInstance
import com.example.studentplacementandroidapp.model.DBStudentDataResult

class Repository {

    suspend fun getStudentData() : DBStudentDataResult{
        return RetrofitInstance.api.getStudentData()
    }

}