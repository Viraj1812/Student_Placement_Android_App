package com.example.studentplacementandroidapp.api

import com.example.studentplacementandroidapp.model.DBCompanyData
import com.example.studentplacementandroidapp.model.DBEditedStudentDataResult
import com.example.studentplacementandroidapp.model.DBStudentDataResult
import com.example.studentplacementandroidapp.utils.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SimpleApi {

    @GET("")
    suspend fun getStudentData() : DBStudentDataResult

    @GET("api")
    suspend fun getCompanyData() : DBCompanyData

    @GET("")
    suspend fun getStudentSaveCompanyData() : DBStudentDataResult

    @GET("")
    suspend fun getStudentSaveData() : DBStudentDataResult

    @POST("api/register")
    suspend fun pushPost(
        @Body post:DBStudentDataResult
    ): Response<DBStudentDataResult>

    @POST("api/register")
    suspend fun pushEditPost(
        @Body post:DBEditedStudentDataResult
    ): Response<DBEditedStudentDataResult>

}