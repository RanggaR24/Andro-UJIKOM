package com.example.loginregisterfirebase.model

import android.content.ContentValues.TAG
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text
import java.util.Date
import kotlin.coroutines.coroutineContext

class UserModel {
    fun create(namaPelapor: String, Notelp: String, lokasikejadian
    : String, tanggalKejadian: String, isilaporan: String) {
        val db = FirebaseFirestore.getInstance()
        val user = hashMapOf(
            "nama" to namaPelapor,
            "no_telp" to Notelp,
            "lokasi" to lokasikejadian,
            "tgl_kejadian" to tanggalKejadian,
            "isi_laporan" to isilaporan
        )

        db.collection("pengaduan")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.id)
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
    }
//    private val db = FirebaseFirestore.getInstance()
//    fun readData(onSuccess: (List<Map<String, Any>>) -> Unit, onFailure: (Exception) -> Unit) {
//        db.collection("pengaduan")
//            .get()
//            .addOnSuccessListener { result ->
//                val dataList = mutableListOf<Map<String, Any>>()
//                for (document in result) {
//                    dataList.add(document.data)
//                }
//                onSuccess(dataList)
//            }
//            .addOnFailureListener(onFailure)
//    }
}