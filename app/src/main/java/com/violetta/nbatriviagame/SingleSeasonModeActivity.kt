package com.violetta.nbatriviagame

import com.violetta.nbatriviagame.model.Question
import com.violetta.nbatriviagame.model.QuestionRepository
import com.violetta.nbatriviagame.views.BaseTriviaActivity

class SingleSeasonModeActivity : BaseTriviaActivity() {
    private lateinit var questionRepository: QuestionRepository

    override fun getQuestions(): MutableList<Question> {
        questionRepository = QuestionRepository()
        return questionRepository.loadQuestions(this, "single_season")
    }
}