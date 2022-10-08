package com.example.studentplacementandroidapp.model

data class DBEditedStudentDataResult(
    val id: String,
    val first_name: String,
    val last_name: String,
    val email: String,
    val phone_number: Long,
    val city: String,
    val department: String,
    val ssc_per: Float,
    val hsc_per: Float,
    val diploma_cgpa: Float?,
    val current_cgpa: Float?,
    val role: String
)
