package com.example.loginregisterfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore

class DetailActivity : AppCompatActivity() {
    private val mFirestore = FirebaseFirestore.getInstance()
    private val PengaduanCollection = mFirestore.collection("pengaduan")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var txtJudul: TextView = findViewById(R.id.txtJudul)
        var txtNama: TextView = findViewById(R.id.txtNamaPelapor)
        var txtDeskripsi: TextView = findViewById(R.id.txtDeskripsi)
        var txtTanggal: TextView = findViewById(R.id.txtTanggal)
        var backIcon: ImageView = findViewById(R.id.back)
        var btnEdit: ImageView = findViewById(R.id.btnEdit)
        var btnDelete: ImageView = findViewById(R.id.btnDelete)

        val documentId = intent.getStringExtra("documentId").toString()

        backIcon.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        btnEdit.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra("documentId", documentId)
            startActivity(intent)
        }

        btnDelete.setOnClickListener {
            deleteById(documentId)
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        FirebaseFirestore.getInstance().collection("pengaduan").document(documentId).get()
            .addOnSuccessListener { data ->
                txtJudul.text = data.getString("judul")?: ""
                txtTanggal.text = data.getString("tanggal")?: ""
                txtNama.text = data.getString("nama")?: ""
                txtDeskripsi.text = data.getString("deskripsi")?: ""
            }
    }

    private fun deleteById(id: String) {
        //menghapus data berdasarkan id document
        PengaduanCollection.document(id)
            .delete()
            .addOnCompleteListener { Toast.makeText(this, "Succes Hapus data", Toast.LENGTH_SHORT).show() }
            .addOnFailureListener { Toast.makeText(this, "Gagal Hapus data", Toast.LENGTH_SHORT).show() }
    }
}