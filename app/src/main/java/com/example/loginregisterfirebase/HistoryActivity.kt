package com.example.loginregisterfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore


class HistoryActivity : AppCompatActivity() {
    lateinit var dataSets: MutableList<Report>
    lateinit var rView: RecyclerView
    lateinit var backIcon: ImageView
    private var adapter: HistoryAdapter<Any?, Any?>? = null
    private var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        dataSets = mutableListOf()
        initView()
        getData()

//        backIcon = findViewById(R.id.back)
//        backIcon.setOnClickListener {
//            startActivity(Intent(this, MainActivity::class.java))
//        }
    }

    private fun getData() {
        db.collection("pengaduan")
            .whereEqualTo("nama", "Rangga Ramadhan") // kondisi pencarian
            .get().addOnSuccessListener { documents ->
            for (document in documents) {
                val documentId = document.id
                val nama = document["nama"].toString()
                val tanggal = document["tgl_kejadian"].toString()
                val no_telp = document["no_telp"].toString()
                val lokasi = document["lokasi"].toString()
                val isi_laporan = document["isi_laporan"].toString()
                dataSets.add(Report(documentId, nama, tanggal, lokasi, isi_laporan,))
            }
            for (dataItem in dataSets){
                adapter?.addItem(ArrayList(dataSets))
                adapter?.notifyDataSetChanged()
            }
        }

//        adapter?.setOnClickItem {
//            val intent = Intent(this, DetailActivity::class.java)
//            intent.putExtra("documentId", it.documentId)
//            startActivity(intent)
//        }
    }
    private fun initView() {
        rView = findViewById(R.id.rview)

        rView.layoutManager = LinearLayoutManager(this)
        adapter = HistoryAdapter()
        rView.adapter = adapter
    }
}