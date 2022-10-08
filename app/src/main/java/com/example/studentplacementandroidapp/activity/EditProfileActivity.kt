package com.example.studentplacementandroidapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentplacementandroidapp.adapter.CompanyDataAdapter
import com.example.studentplacementandroidapp.databinding.ActivityEditProfileBinding
import com.example.studentplacementandroidapp.fragment.ProfileFragment
import com.example.studentplacementandroidapp.model.DBEditedStudentDataResult
import com.example.studentplacementandroidapp.model.DBStudentDataResult
import com.example.studentplacementandroidapp.model.MainViewModel
import com.example.studentplacementandroidapp.model.MainViewModelFactory
import com.example.studentplacementandroidapp.repository.Repository

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
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
        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        getData()
        setData()

        binding.llNext1.setOnClickListener{
            binding.llRegistrationForm1.visibility = View.GONE
            binding.llNext1.visibility = View.GONE
            binding.llRegistrationForm2.visibility = View.VISIBLE
            binding.llNext2.visibility = View.VISIBLE
        }

        binding.llNext2.setOnClickListener{
            seteditedData()
            val check : Boolean = (id.isNotEmpty() && firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && !(phoneNumber.equals(0)) && city.isNotEmpty() && department.isNotEmpty() && sscPer.toString().isNotEmpty() && currentCgpa.toString().isNotEmpty() )
            if(check) {
                val myPost = DBEditedStudentDataResult(
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
                viewModel.pushEditPost(myPost)
                viewModel.myResponseOfRegisterStudent.observe(this, Observer{response ->
                    if(response.isSuccessful){
                        Toast.makeText(this, "Submited", Toast.LENGTH_LONG).show()
                        val intent = Intent(this@EditProfileActivity, MainActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,"Submit Again", Toast.LENGTH_LONG).show()
                    }
                })
            }
            else{
                Toast.makeText(this,"Enter All Required Fields", Toast.LENGTH_LONG).show()
            }
        }



    }



    private fun setData() {
        binding.city.setText(city)
        binding.firstName.setText(firstName)
        binding.lastName.setText(lastName)
        binding.studentId.setText(id)
        binding.tenthPercentage.setText(sscPer.toString())
        binding.twelthPercentage.setText(hscPer.toString())
        binding.department.setText(department)
        binding.diplomaCGPA.setText(diplomaCgpa.toString())
        binding.currentCGPA.setText(currentCgpa.toString())
        binding.email.setText(email)
        binding.mobileNumber.setText(phoneNumber.toString())
    }

    private fun getData() {
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.getStudentSaveData()
        viewModel.myResponseOfStudentSaveData.observe(this) {response->
            id = response.id
            firstName = response.first_name
            lastName = response.last_name
            email = response.email
            city = response.city
            phoneNumber = response.phone_number
            department = response.department
            sscPer = response.ssc_per
            hscPer = response.hsc_per
            diplomaCgpa = response.diploma_cgpa
            currentCgpa = response.current_cgpa
        }
    }

    private fun seteditedData() {
        id = binding.studentId.text.toString().trim()
        firstName = binding.firstName.text.toString().trim()
        lastName = binding.lastName.text.toString().trim()
        email = binding.email.text.toString().trim()
        phoneNumber = binding.mobileNumber.text.toString().toLong()
        city = binding.city.text.toString().trim()
        department = binding.department.text.toString().trim()
        sscPer = binding.tenthPercentage.text.toString().toFloat()
        hscPer = binding.twelthPercentage.text.toString().toFloat()
        if (hscPer.toString().isEmpty()) {
            diplomaCgpa = binding.diplomaCGPA.text.toString().toFloat()
        }
    }
}