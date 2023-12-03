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
    /** Repository instance for loading trivia questions. */
    private lateinit var questionRepository: QuestionRepository

    /**
     * Loads and returns a list of questions for the career stats mode.
     * Overrides from [BaseTriviaActivity] and provides a specific implementation
     * for loading questions tailored for the career stats mode of the game.
     * @return MutableList of [Question] objects for the career stats mode.
     */
    override fun getQuestions(): MutableList<Question> {
        questionRepository = QuestionRepository()
        return questionRepository.loadQuestions(this, "career_stats")
    }
}