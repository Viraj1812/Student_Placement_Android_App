package com.example.studentplacementandroidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.studentplacementandroidapp.databinding.ActivityRegistrationBinding
import com.example.studentplacementandroidapp.model.DBStudentDataResult
import com.example.studentplacementandroidapp.model.MainViewModel
import com.example.studentplacementandroidapp.model.MainViewModelFactory
import com.example.studentplacementandroidapp.repository.Repository

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var id : String
    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var email: String
    private var phoneNumber: Long = 0
    private lateinit var city: String
    private lateinit var department: String
    private var sscPer: Float = 0.0f
    private var hscPer: Float = 0.0f
    private var diplomaCgpa: Float? = null
    private var currentCgpa: Float? = null
    private var role: String = "sde"

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        binding.llNext1.setOnClickListener{
            binding.llRegistrationForm1.visibility = GONE
            binding.llNext1.visibility = GONE
            binding.llRegistrationForm2.visibility = VISIBLE
            binding.llNext2.visibility = VISIBLE
        }

        binding.llNext2.setOnClickListener {
            setStudentData()
            val check : Boolean = (id.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && !(phoneNumber.equals(0)) && city.isNotEmpty() && department.isNotEmpty() && sscPer.toString().isNotEmpty() && currentCgpa.toString().isNotEmpty() )
            if(check) {
                val myPost = DBStudentDataResult(
                    id,
                    firstName,
                    lastName,
                    email,
                    phoneNumber,
                    city,
                    department,
                    sscPer,
                    hscPer,
                    diplomaCgpa,
                    currentCgpa,
                    role
                )
                viewModel.pushPost(myPost)
                viewModel.myResponseOfRegisterStudent.observe(this, Observer{response ->
                    if(response.isSuccessful){
                        Toast.makeText(this, "Submited", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@RegistrationActivity, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Submit Again",Toast.LENGTH_LONG).show()
                    }
                })
            }
            else{
                Toast.makeText(this,"Enter All Required Fields",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun setStudentData() {

        id = binding.studentId.text.toString().trim()
        firstName = binding.firstName.text.toString().trim()
        lastName = binding.lastName.text.toString().trim()
        email = binding.email.text.toString().trim()
        /*val st = binding.mobileNumber.text.toString()
        if(st.isNotEmpty()) {
            phoneNumber = st.toLong()
        }*/

        phoneNumber = binding.mobileNumber.text.toString().toLong()
        city = binding.city.text.toString().trim()
        department = binding.department.text.toString().trim()
        sscPer = binding.tenthPercentage.text.toString().toFloat()
        hscPer = binding.twelthPercentage.text.toString().toFloat()
        if(hscPer.toString().isEmpty()) {
            diplomaCgpa = binding.diplomaCGPA.text.toString().toFloat()
        }
        currentCgpa = binding.currentCGPA.text.toString().toFloat()
    }
}