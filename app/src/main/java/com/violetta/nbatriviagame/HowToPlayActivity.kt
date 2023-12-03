package com.violetta.nbatriviagame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.violetta.nbatriviagame.utils.Globals

class HowToPlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_how_to_play)
        Globals.setRandomBackground(this)

        val buttonReturnHome = findViewById<Button>(R.id.button_return_home)
        buttonReturnHome.setOnClickListener {
            finish() // Closes this activity and returns to the previous one
        }
    }
}