package com.zainal.playerlist

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    private var title: String = "Profile Pemain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitvity_detail)
        setActionBatTitle(title)

//        Log.d("TAG", "onCreated: started")

        var tvName: TextView = findViewById(R.id.tv_item_name)
        var tvProfile: TextView = findViewById(R.id.tv_item_profile)
        var imgPhoto: ImageView = findViewById(R.id.img_item_photo)

        val name = intent.getStringExtra(EXTRA_NAME)
        val playerProfile = intent.getStringExtra(EXTRA_PROFILE)
        val playerPhoto = intent.getStringExtra(EXTRA_PHOTO)

        Glide.with(this)
            .load(playerPhoto)
            .apply(RequestOptions().override(350, 450))
            .into(imgPhoto)

        tvName.text = name
        tvProfile.text = playerProfile

    }

    private fun setActionBatTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar  as ActionBar).title = title
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_PROFILE = "extra_profile"
        const val EXTRA_PHOTO = "extra_photo"
    }

}