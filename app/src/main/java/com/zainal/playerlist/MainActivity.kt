package com.zainal.playerlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
//import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvPlayers: RecyclerView
    private var list: ArrayList<Player> = arrayListOf()
    private var title: String = "Daftar Pemain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBatTitle(title)

        rvPlayers = findViewById(R.id.rv_players)
        rvPlayers.setHasFixedSize(true)

        list.addAll(PlayersData.listData)
        showRecyclerList()
    }

    private fun setActionBatTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar  as ActionBar).title = title
        }
    }

    private fun showSelectedPlayer(player: Player) {
//        Toast.makeText(this, "Kamu Memillih " + player.name, Toast.LENGTH_SHORT).show()
        val detailIntent = Intent(this@MainActivity, DetailActivity::class.java)
        detailIntent.putExtra(DetailActivity.EXTRA_NAME, player.name)
        detailIntent.putExtra(DetailActivity.EXTRA_PROFILE, player.player_profile)
        detailIntent.putExtra(DetailActivity.EXTRA_PHOTO, player.photo)
        startActivity(detailIntent)
    }

    private fun showRecyclerList() {
        rvPlayers.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(list)
        rvPlayers.adapter = listPlayerAdapter

        listPlayerAdapter.setOnItemClickCallback(object : ListPlayerAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Player) {
                showSelectedPlayer(data)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMenu: Int) {
        when(selectedMenu){
            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
    }

}
