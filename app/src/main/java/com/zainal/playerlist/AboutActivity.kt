package com.zainal.playerlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar

class AboutActivity : AppCompatActivity() {

    private lateinit var aboutName: TextView
    private lateinit var aboutEmail: TextView
    private lateinit var aboutImage: ImageView

    private var title: String = "About"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        setActionBatTitle(title)

        aboutName = findViewById(R.id.about_name)
        aboutEmail = findViewById(R.id.about_email)
        aboutImage = findViewById(R.id.img_about_profile)

    }

    private fun setActionBatTitle(title: String) {
        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = title

        }
    }
}