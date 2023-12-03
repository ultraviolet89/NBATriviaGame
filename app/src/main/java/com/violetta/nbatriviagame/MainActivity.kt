package com.violetta.nbatriviagame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.violetta.nbatriviagame.utils.Globals

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Globals.setRandomBackground(this)

        val buttonCareer = findViewById<Button>(R.id.button_career_mode)
        buttonCareer.setOnClickListener {
            startActivity(Intent(this, CareerStatsModeActivity::class.java))
        }

        val buttonSingleSeason = findViewById<Button>(R.id.button_single_season_mode)
        buttonSingleSeason.setOnClickListener {
            startActivity(Intent(this, SingleSeasonModeActivity::class.java))
        }

        val buttonHowToPlay = findViewById<Button>(R.id.button_how_to_play)
        buttonHowToPlay.setOnClickListener {
            startActivity(Intent(this, HowToPlayActivity::class.java))
        }
    }
}