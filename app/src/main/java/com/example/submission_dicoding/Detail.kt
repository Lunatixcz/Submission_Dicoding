package com.example.submission_dicoding

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Fish>("DATA")

        val dataImage : ImageView = findViewById(R.id.main_image)
        val dataName : TextView = findViewById(R.id.fish_name)
        val dataLatin : TextView = findViewById(R.id.latin_name)
        val dataOrigin : TextView = findViewById(R.id.origin)

        data?.let {
            Glide.with(this)
                .load(it.photo)
                .into(dataImage)
            dataName.text = it.name
            dataLatin.text = it.latin
            dataOrigin.text= it.origin
        }
    }
}