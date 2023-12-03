package com.violetta.nbatriviagame.controller

import android.util.Log
import com.violetta.nbatriviagame.model.Question

/**
 * Controller class for managing trivia game logic.
 * Handles the progression of the trivia game, including keeping track of questions, the current score,
 * and whether the game has ended.
 * @property questions The list of questions for the trivia game.
 */
class Trivia(private val questions: MutableList<Question>) {
    /** Index of the current question */
    private var currentQuestionIndex = 0
    /** Current score of the player  */
    var score = 0

    val isGameOver: Boolean
        get() = currentQuestionIndex >= questions.size -1

    /** Retrieves the current question from the list of questions */
    val currentQuestion: Question
        get() = questions[currentQuestionIndex]

    /**
     * Checks if the selected answer is correct for the current question.
     * Increments the score if the answer is correct.
     *
     * @param selectedIndex selected answer index option.
     * @return True if answer is correct, False otherwise.
     */
    fun checkAnswer(selectedIndex: Int): Boolean {
        val selectedAnswer = currentQuestion.options[selectedIndex]
        val isCorrect = currentQuestion.answer == selectedAnswer
        if (isCorrect) score++

        Log.d("TriviaGame", "Game Over: $isGameOver")
        return isCorrect
    }

    /**
     * Advances to the next question
     * @return The next question or null if the game is over
     */
    fun nextQuestion(): Question? {
        if (!isGameOver) {
            currentQuestionIndex++
            return currentQuestion
        }
        return null
    }

    /**
     * @return A list of answer options for the current question.
     */
    fun getCurrentQuestionOptions(): List<String> {
        return currentQuestion.options
    }

}