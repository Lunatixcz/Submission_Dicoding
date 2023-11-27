package com.example.submission_dicoding

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {
    private var data: Fish? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        data = intent.getParcelableExtra("DATA")
        Log.d("Detail", data?.photo.toString())

        val dataImage: ImageView = findViewById(R.id.main_image)
        val dataName: TextView = findViewById(R.id.fish_name)
        val dataLatin: TextView = findViewById(R.id.latin_name)
        val dataOrigin: TextView = findViewById(R.id.origin)

        data?.let {
            Glide.with(this)
                .load(it.photo)
                .placeholder(R.drawable.brown_fish_icon_fishing_logo)
                .into(dataImage)
            dataName.text = it.name
            dataLatin.text = it.latin
            dataOrigin.text = it.origin
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_share -> {
                shareContent()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun shareContent() {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this fish: ${data?.name}")
        startActivity(Intent.createChooser(shareIntent, "Share using"))
    }
}
