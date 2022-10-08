package com.example.studentplacementandroidapp.repository

import com.example.studentplacementandroidapp.api.RetrofitInstance
import com.example.studentplacementandroidapp.model.DBCompanyData
import com.example.studentplacementandroidapp.model.DBEditedStudentDataResult
import com.example.studentplacementandroidapp.model.DBStudentDataResult
import retrofit2.Response
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

    suspend fun pushPost(post: DBStudentDataResult): Response<DBStudentDataResult> {
        return RetrofitInstance.api.pushPost(post)
    }

    suspend fun pushEditPost(post: DBEditedStudentDataResult): Response<DBEditedStudentDataResult> {
        return RetrofitInstance.api.pushEditPost(post)
    }


}