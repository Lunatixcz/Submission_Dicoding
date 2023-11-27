package com.example.submission_dicoding

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val imgLogo : ImageView = findViewById(R.id.logo)
        imgLogo.alpha = 0f
        imgLogo.animate().setDuration(1500).alpha(1f).withEndAction(){
            val i = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
            finish()
        }
    }
}