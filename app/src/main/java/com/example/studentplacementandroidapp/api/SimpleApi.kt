package com.example.studentplacementandroidapp.api

import com.example.studentplacementandroidapp.model.DBCompanyData
import com.example.studentplacementandroidapp.model.DBStudentDataResult
import com.example.studentplacementandroidapp.utils.Constants.Companion.BASE_URL
import retrofit2.http.GET

interface SimpleApi {

    @GET("")
    suspend fun getStudentData() : DBStudentDataResult

    @GET("api")
    suspend fun getCompanyData() : DBCompanyData

    @GET("")
    suspend fun getStudentSaveCompanyData() : DBStudentDataResult

    @GET("")
    suspend fun getStudentSaveData() : DBStudentDataResult

}