package com.violetta.nbatriviagame

import QuestionRepository
import com.violetta.nbatriviagame.model.Question
import com.violetta.nbatriviagame.views.BaseTriviaActivity


/**
 * Activity handles the display and interaction for the single season trivia mode.
 *
 * This activity extends [BaseTriviaActivity] and specializes in presenting questions
 * and handling user interactions specifically for the career stats mode of the trivia game.
 * Loads [QuestionRepository] to the appropriate set of questions for this mode.
 * */
class SingleSeasonModeActivity : BaseTriviaActivity() {
    private val questionRepository = QuestionRepository()

    override fun getQuestions(): MutableList<Question> {
        return questionRepository.loadQuestions(this, "single_season")
    }
}

