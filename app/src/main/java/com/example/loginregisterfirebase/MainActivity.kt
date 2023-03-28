package com.example.loginregisterfirebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nextlaporan = findViewById<ImageView>(R.id.nextlaporan)
        val nexthistory = findViewById<ImageView>(R.id.nexthistory)

        nextlaporan.setOnClickListener {
            val imageView = Intent(this, ReportActivity::class.java)
            startActivity(imageView)
        }
        nexthistory.setOnClickListener {
            val imageView = Intent(this, HistoryActivity::class.java)
            startActivity(imageView)
        }
    }
}