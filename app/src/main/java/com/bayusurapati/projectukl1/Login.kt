package com.bayusurapati.projectukl1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    private lateinit var tvReceived: TextView
    private lateinit var rvToko: RecyclerView
    private var list: ArrayList<tokoClass> = arrayListOf()

    private var title: String = "MODE SENYUM"

    lateinit var cardTokoAdapter: CardShopActivity
    lateinit var gridTokoAdapter: GridShopActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        rvToko = findViewById(R.id.rv_toko)
        rvToko.setHasFixedSize(true)

        list.addAll(tokoData.listData)
        showRecycleCard()

        supportActionBar?.setLogo(R.drawable.scottish_drink)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun showRecycleCard(){
        rvToko.layoutManager = LinearLayoutManager(this)
        cardTokoAdapter = CardShopActivity(list)
        gridTokoAdapter = GridShopActivity(list)
        rvToko.adapter = cardTokoAdapter
        setActionBarTitle(title)
    }
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_switch, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.grid -> {
                title = "Mode Grid"
                setActionBarTitle(title)
                rvToko.layoutManager = GridLayoutManager(this, 2)
                rvToko.adapter = gridTokoAdapter
            }
            R.id.card -> {
                title = "Mode Card View"
                setActionBarTitle(title)
                rvToko.layoutManager = LinearLayoutManager(this)
                rvToko.adapter = cardTokoAdapter
            }
        }
    }

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }
}