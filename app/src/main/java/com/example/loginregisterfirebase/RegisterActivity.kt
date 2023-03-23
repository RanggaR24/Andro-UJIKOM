package com.example.loginregisterfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginregisterfirebase.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class RegisterActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
//    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        uiUnit()

        binding.textViewlogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnsignup.setOnClickListener{
             val name = binding.name.text.toString()
             val email = binding.email.text.toString()
             val nik = binding.nik.text.toString()
             val telepon = binding.telepon.text.toString()
             val password = binding.password.text.toString()
             val confirmPasswaord = binding.konfirpassword.text.toString()

             if (email.isNotEmpty() && password.isNotEmpty() && confirmPasswaord.isNotEmpty() && name.isNotEmpty() && nik.isNotEmpty() && telepon.isNotEmpty()){
                 if (password == confirmPasswaord) {

                     firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                         if (it.isSuccessful){
                             val intent = Intent(this , LoginActivity::class.java)
                             startActivity(intent)
                         }else{
                             Toast.makeText(this , it.exception.toString() , Toast.LENGTH_SHORT).show()
                         }
                     }
                 }else{
                     Toast.makeText(this , "Password Tidak Sesuai" , Toast.LENGTH_SHORT).show()
                 }
             }else{
                 Toast.makeText(this , "Mohon Isi Data Dengan Lengkap !!" , Toast.LENGTH_SHORT).show()
             }

        }
    }

//    private fun uiUnit() {
//        firebaseAuth = FirebaseAuth.getInstance()

    }