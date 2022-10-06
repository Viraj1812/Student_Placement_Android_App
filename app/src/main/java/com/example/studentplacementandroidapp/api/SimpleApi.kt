package com.example.studentplacementandroidapp.api

import com.example.studentplacementandroidapp.model.DBStudentDataResult
import retrofit2.http.GET

interface SimpleApi {

    @GET("")
    suspend fun getStudentData() : DBStudentDataResult

}