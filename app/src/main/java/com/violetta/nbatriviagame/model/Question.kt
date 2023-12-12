package com.violetta.nbatriviagame.model

import android.adservices.adid.AdId

/**
 * Represents a trivia question with multiple choice answers.
 *
 * Class encapsulates the data for a single trivia question, including the question text,
 * a list of possible answers, and the index of the correct answer.
 *
 * @property text The text of the trivia question.
 * @property options A list of possible answers for the trivia question.
 * @property answer The correct answer to the trivia question.
 */
class Question{
     var questionId: Int = 0
     var questionText: String = ""
     var options: List<String> = arrayListOf()
     var answer: String = ""

    constructor(questionId:Int, questionText:String, answer:String){
        this.questionId = questionId
        this.questionText = questionText
        this.answer = answer
    }

    fun addOptions(options:ArrayList<String>){
        this.options = options
    }


}




