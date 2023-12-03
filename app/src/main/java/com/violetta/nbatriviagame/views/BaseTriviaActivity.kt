package com.violetta.nbatriviagame.views

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.violetta.nbatriviagame.R
import com.violetta.nbatriviagame.utils.Globals
import com.violetta.nbatriviagame.controller.Trivia
import com.violetta.nbatriviagame.model.Question
import androidx.appcompat.app.AlertDialog

abstract class BaseTriviaActivity : AppCompatActivity() {
    private lateinit var triviaController: Trivia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trivia)
        Globals.setRandomBackground(this)

        triviaController = Trivia(getQuestions())
        setupQuestionView()
        setupAnswerButtons()

        val buttonReturnHome = findViewById<Button>(R.id.button_return_home)
        buttonReturnHome.setOnClickListener {
            finish() // Closes this activity and returns to the previous one
        }
    }

    abstract fun getQuestions(): MutableList<Question>

    private fun setupQuestionView() {
        displayNextQuestion()
    }

    private fun setupAnswerButtons() {
        val buttons = arrayOf(
            findViewById(R.id.buttonOption1),
            findViewById(R.id.buttonOption2),
            findViewById(R.id.buttonOption3),
            findViewById<Button>(R.id.buttonOption4)
        )

        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                if (triviaController.checkAnswer(index)) {
                    updateScoreView()
                }
                if (triviaController.isGameOver) {
                    showEndGameAlert()
                } else {
                    triviaController.nextQuestion()
                    displayNextQuestion()
                }
            }
        }
    }

    private fun displayNextQuestion() {
        val question = triviaController.currentQuestion
        findViewById<TextView>(R.id.textViewQuestion).text = question.text

        val options = triviaController.getCurrentQuestionOptions()
        val buttons = arrayOf(
            findViewById(R.id.buttonOption1),
            findViewById(R.id.buttonOption2),
            findViewById(R.id.buttonOption3),
            findViewById<Button>(R.id.buttonOption4)
        )

        options.forEachIndexed { index, option ->
            buttons[index].text = option
        }
    }

    private fun updateScoreView() {
        val scoreText = getString(R.string.score_text, triviaController.score)
        findViewById<TextView>(R.id.textViewScore).text = scoreText
    }

    private fun showEndGameAlert() {
        Log.d("TriviaGame", "Showing end game alert.")
        AlertDialog.Builder(this)
            .setTitle("Game Over")
            .setMessage("Your total score is: ${triviaController.score}")
            .setPositiveButton("OK") { _, _ -> finish() }
            .show()
    }
}