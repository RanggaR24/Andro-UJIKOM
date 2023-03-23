package com.example.loginregisterfirebase.model

import android.content.ContentValues.TAG
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
            "Notelp" to Notelp,
            "lokasi" to lokasikejadian,
            "tgl" to tanggalKejadian,
            "isilaporan" to isilaporan
        )

        db.collection("pengaduan")
            .add(user)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.id)
            }
            .addOnFailureListener { e -> Log.w(TAG, "Error adding document", e) }
    }
}