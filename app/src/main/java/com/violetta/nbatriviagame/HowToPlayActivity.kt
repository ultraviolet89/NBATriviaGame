package com.violetta.nbatriviagame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.violetta.nbatriviagame.utils.Globals

/**
 * Activity for displaying instructions on how to play the trivia game, the game's rules and guidelines to the user.
 */
class HowToPlayActivity : AppCompatActivity() {
    /**
     * Called when the activity is starting.
     *
     * This is where most initialization should go: calling [setContentView] to inflate
     * the activity's UI, setting up UI components, and initial configuration.
     */
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