package com.violetta.nbatriviagame

import com.violetta.nbatriviagame.model.Question
import com.violetta.nbatriviagame.model.QuestionRepository
import com.violetta.nbatriviagame.views.BaseTriviaActivity

/**
 * Activity for handling the career stats trivia mode in the game.
 *
 * This activity extends [BaseTriviaActivity] and specializes in presenting questions
 * and handling user interactions specifically for the career stats mode of the trivia game.
 * Loads [QuestionRepository] to the appropriate set of questions for this mode.
 */
class CareerStatsModeActivity : BaseTriviaActivity() {
    private lateinit var questionRepository: QuestionRepository

    override fun getQuestions(): MutableList<Question> {
        questionRepository = QuestionRepository(this)
        return questionRepository.loadQuestions("career_stats")
    }
}