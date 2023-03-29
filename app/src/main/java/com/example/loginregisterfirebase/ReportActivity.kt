package com.example.loginregisterfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginregisterfirebase.model.UserModel
import com.google.firebase.firestore.auth.User

class ReportActivity : AppCompatActivity() {

    private lateinit var tnama : EditText
    private lateinit var tnotelp : EditText
    private lateinit var inputLokasi: EditText
    private lateinit var inputTanggal : EditText
    private lateinit var inputLaporan : EditText
    private lateinit var btnsendlaporan : Button
    private lateinit var userModel: UserModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)
        initView()

        btnsendlaporan.setOnClickListener {
            if (validateForm()) {
                userModel.create(
                    tnama.text.toString(),
                    tnotelp.text.toString(),
                    inputLokasi.text.toString(),
                    inputTanggal.text.toString(),
                    inputLaporan.text.toString()
                )
                btnsendlaporan.isEnabled = true
                clear()
                Toast.makeText(this, "Laporan berhasil dikirim", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Laporan gagal dikirim. Mohon isi semua data dengan benar", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initView() {
        tnama = findViewById(R.id.txtinputNama)
        tnotelp = findViewById(R.id.txtinputTelepon)
        inputLokasi = findViewById(R.id.txtinputLokasi)
        inputTanggal = findViewById(R.id.txtinputTanggal)
        inputLaporan = findViewById(R.id.txtinputLaporan)
        btnsendlaporan = findViewById(R.id.btnsendlaporan)

        userModel = UserModel()
    }

    private fun clear(){
        tnama.setText("")
        tnotelp.setText("")
        inputLokasi.setText("")
        inputTanggal.setText("")
        inputLaporan.setText("")
    }

    fun validateForm(): Boolean {
        var isValid = true

        if (tnama.text.toString().isEmpty()) {
            tnama.error = "Nama harus di isi"
            isValid = false
        }

        if (tnotelp.text.toString().isEmpty()) {
            tnotelp.error = "Telepon harus di isi"
            isValid = false
        }

        if (inputLokasi.text.toString().isEmpty()) {
            inputLokasi.error = "Lokasi harus di isi"
            isValid = false
        }

        if (inputTanggal.text.toString().isEmpty()) {
            inputTanggal.error = "Tanggal harus di isi"
            isValid = false
        }

        if (inputLaporan.text.toString().isEmpty()) {
            inputLaporan.error = "Laporan harus di isi"
            isValid = false
        }

        return isValid
    }
}




