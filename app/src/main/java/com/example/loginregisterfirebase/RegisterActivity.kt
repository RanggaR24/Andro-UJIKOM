package com.example.loginregisterfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.loginregisterfirebase.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class RegisterActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth

    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance() // inisialisasi variabel firebaseAuth

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
                        if (it.isSuccessful) {
                            val userId = firebaseAuth.currentUser?.uid
                            if (userId != null) {
                                val data = hashMapOf(
                                    "name" to name,
                                    "email" to email,
                                    "nik" to nik,
                                    "telepon" to telepon,
                                )

                                db.collection("masyarakat")
                                    .document(userId)
                                    .set(data)
                                    .addOnSuccessListener {
                                        Toast.makeText(this , "Register Berhasil" , Toast.LENGTH_SHORT).show()
                                    }
                                    .addOnFailureListener {
                                        Toast.makeText(this , "Register Gagal" , Toast.LENGTH_SHORT).show()
                                    }
                            }
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
}