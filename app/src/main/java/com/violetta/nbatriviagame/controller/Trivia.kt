package com.violetta.nbatriviagame.controller

import android.util.Log
import com.violetta.nbatriviagame.model.Question

class Trivia(private val questions: MutableList<Question>) {
    private var currentQuestionIndex = 0
    var score = 0

    val isGameOver: Boolean
        get() = currentQuestionIndex >= questions.size -1

    val currentQuestion: Question
        get() = questions[currentQuestionIndex]

    fun checkAnswer(selectedIndex: Int): Boolean {
        val selectedAnswer = currentQuestion.options[selectedIndex]
        val isCorrect = currentQuestion.answer == selectedAnswer
        if (isCorrect) score++

        Log.d("TriviaGame", "Game Over: $isGameOver")
        return isCorrect
    }

    fun nextQuestion(): Question? {
        if (!isGameOver) {
            currentQuestionIndex++
            return currentQuestion
        }
        return null
    }
    fun getCurrentQuestionOptions(): List<String> {
        return currentQuestion.options
    }

}