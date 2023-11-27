package com.example.submission_dicoding

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val color = resources.getColor(R.color.secondary)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(color))
    }
}