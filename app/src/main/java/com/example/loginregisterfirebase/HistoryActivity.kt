package com.example.loginregisterfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.loginregisterfirebase.databinding.ActivityHistoryBinding
import com.example.loginregisterfirebase.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class HistoryActivity : AppCompatActivity() {
    private lateinit var tvNama: TextView
    private lateinit var tvLaporan: TextView
    private lateinit var tvLokasi: TextView

    private var db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        tvNama = findViewById(R.id.tvNama)
        tvLaporan = findViewById(R.id.tvLaporan)
        tvLokasi = findViewById(R.id.tvLokasi)

        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("pengaduan").document(userId)
        ref.get().addOnSuccessListener {
            if (it != null) {
                val nama = it.data?.get("nama")?.toString()
                val laporan = it.data?.get("isi_laporan")?.toString()
                val lokasi = it.data?.get("lokasi")?.toString()

                tvNama.text = nama
                tvLaporan.text = laporan
                tvLokasi.text = lokasi
            }
        }
            .addOnFailureListener {Toast.makeText(this,"Failed!", Toast.LENGTH_SHORT).show()
            }


    }

}