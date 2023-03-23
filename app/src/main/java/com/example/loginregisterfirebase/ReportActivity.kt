package com.example.loginregisterfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.loginregisterfirebase.model.UserModel
import com.google.firebase.firestore.auth.User

class ReportActivity : AppCompatActivity() {

    private lateinit var tnama : EditText
    private lateinit var tnotelp : EditText
    private lateinit var inputLokasi: EditText
    private lateinit var inputTanggal : EditText
    private lateinit var inputLaporan : EditText
    private lateinit var btnPost : Button
    private lateinit var userModel: UserModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        initView()

        btnPost.setOnClickListener {
            userModel.create(
                tnama.text.toString(),
                tnotelp.text.toString(),
                inputLokasi.text.toString(),
                inputTanggal.text.toString(),
                inputLaporan.text.toString())}
            clear()


        }
    private fun initView() {
        tnama = findViewById(R.id.txtinputNama)
        tnotelp = findViewById(R.id.txtinputTelepon)
        inputLokasi = findViewById(R.id.txtinputLokasi)
        inputTanggal = findViewById(R.id.txtinputTanggal)
        inputLaporan = findViewById(R.id.txtinputLaporan)
        btnPost = findViewById(R.id.btnsendlaporan)

        userModel = UserModel()
    }
    private fun clear(){
        tnama.setText("")
        tnotelp.setText("")
        inputLokasi.setText("")
        inputTanggal.setText("")
        inputLaporan.setText("")
        btnPost.setEnabled(false)

    }
}



