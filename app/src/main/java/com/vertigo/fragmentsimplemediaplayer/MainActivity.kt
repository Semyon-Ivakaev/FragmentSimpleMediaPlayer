package com.vertigo.fragmentsimplemediaplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(), ButtonFragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, ButtonFragment())
                .commit()
        }
    }

    override fun nextFragmentButtonClickListener() {
        findViewById<Button>(R.id.btn).apply {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, MediaPlayerFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}