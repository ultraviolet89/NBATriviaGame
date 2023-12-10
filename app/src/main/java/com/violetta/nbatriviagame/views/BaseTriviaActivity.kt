package com.violetta.nbatriviagame.views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.violetta.nbatriviagame.R
import com.violetta.nbatriviagame.controller.Trivia
import com.violetta.nbatriviagame.model.Question
import com.violetta.nbatriviagame.utils.Globals

/**
 * An abstract base activity for trivia game modes.
 *
 * This activity provides the common functionality shared across different trivia game modes,
 * such as setting up the question view, answer buttons, and handling the game logic.
 */
abstract class BaseTriviaActivity : AppCompatActivity() {
    private lateinit var triviaController: Trivia

    /**
     * Called when the activity is starting.
     * Sets up the activity layout, initializes the trivia controller, and configures UI components.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trivia)
        Globals.setRandomBackground(this)

        triviaController = Trivia(getQuestions())
        setupQuestionView()
        setupAnswerButtons()

        val buttonReturnHome = findViewById<Button>(R.id.button_return_home)
        buttonReturnHome.setOnClickListener {
            finish()
        }
    }

    /**
     * Abstract method to be implemented by subclasses to provide trivia questions.
     * @return A list of trivia questions.
     */
    abstract fun getQuestions(): MutableList<Question>

    /** Sets up the view for displaying the current trivia question. */
    private fun setupQuestionView() {
        displayNextQuestion()
    }

    /**
     * Sets up answer buttons and their click listeners.
     *
     * Each button associated with an answer option.
     * When clicked, it
     *  - checks the answer
     *  - updates the score view
     *  - proceeds to the next question or ends the game
     */
    private fun setupAnswerButtons() {
        val buttons = arrayOf(
            findViewById(R.id.buttonOption1),
            findViewById(R.id.buttonOption2),
            findViewById(R.id.buttonOption3),
            findViewById<Button>(R.id.buttonOption4)
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                if (::triviaController.isInitialized && triviaController.checkAnswer(index)) {
                    updateScoreView()
                    if (triviaController.isGameOver) {
                        showEndGameAlert()
                    } else {
                        triviaController.nextQuestion()
                        displayNextQuestion()
                    }
                }
            }
        }
    }

    /**
     * Displays the next trivia question and its answer options.
     * Updates the UI with the current question and sets the text for each answer button.
     */
    private fun displayNextQuestion() {
        if (::triviaController.isInitialized) {
            val question = triviaController.getCurrentQuestion()
            question?.let {
                findViewById<TextView>(R.id.textViewQuestion).text = it.questionContent

                val options = triviaController.getCurrentQuestionOptions()
                val buttons = arrayOf(
                    findViewById(R.id.buttonOption1),
                    findViewById(R.id.buttonOption2),
                    findViewById(R.id.buttonOption3),
                    findViewById<Button>(R.id.buttonOption4)
                )

                options.forEachIndexed { index, option ->
                    buttons.getOrNull(index)?.text = option
                }
            }
        } else {
            Log.e("TriviaGame", "Trivia controller is not initialized.")
        }
    }

    /** Updates the score view with the current score. */
    private fun updateScoreView() {
        val scoreText = getString(R.string.score_text, triviaController.score)
        findViewById<TextView>(R.id.textViewScore).text = scoreText
    }

    /**
     * Shows an alert dialog when the game is over, displaying the final score.
     * Closes the activity and returns to the previous screen when the user acknowledges the dialog.
     */
    private fun showEndGameAlert() {
        Log.d("TriviaGame", "Showing end game alert.")
        AlertDialog.Builder(this)
            .setTitle("Game Over")
            .setMessage("Your total score is: ${triviaController.score}")
            .setPositiveButton("OK") { _, _ -> finish() }
            .show()
    }
}
