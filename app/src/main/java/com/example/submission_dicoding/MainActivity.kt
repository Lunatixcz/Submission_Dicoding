package com.example.submission_dicoding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFish : RecyclerView
    private val list = ArrayList<Fish>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFish = findViewById(R.id.rv_fishes)
        rvFish.setHasFixedSize(true)

        list.addAll(getListFish())
        showRecyclerList()
    }

    private fun getListFish() : ArrayList<Fish> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataLatin = resources.getStringArray(R.array.data_latin)
        val dataOrigin = resources.getStringArray(R.array.data_origin)
        val listFish = ArrayList<Fish>()
        for (i in dataName.indices) {
            val Fish = Fish(dataName[i], dataDesc[i], dataPhoto[i], dataLatin[i], dataOrigin[i])
            listFish.add(Fish)
        }
        return listFish
    }

    private fun showRecyclerList(){
        rvFish.layoutManager = LinearLayoutManager(this)
        val listFishAdapter = ListFishAdapter(list)
        rvFish.adapter = listFishAdapter

        listFishAdapter.setOnItemClickCallback(object : ListFishAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fish) {
                val intentToDetail = Intent(this@MainActivity, Detail::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvFish.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFish.layoutManager = GridLayoutManager (this, 2)
            }
            R.id.about -> {
                val intentToAbout = Intent (this@MainActivity, About::class.java)
                startActivity(intentToAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}