package com.example.loginregisterfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler


    class SplashscreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT = 5000L // 5 detik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        Handler().postDelayed({
            // Setelah waktu yang ditentukan, pergi ke activity utama
            startActivity(Intent(this, LoginActivity::class.java))

            // Tutup activity ini agar tidak bisa kembali ke splash screen
            finish()
        }, SPLASH_TIME_OUT)
    }
}