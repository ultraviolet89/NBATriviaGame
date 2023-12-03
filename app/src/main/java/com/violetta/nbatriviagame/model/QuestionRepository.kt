package com.violetta.nbatriviagame.model

import android.content.Context
import com.violetta.nbatriviagame.R
import org.json.JSONObject

class QuestionRepository {
    fun loadQuestions(context: Context, mode: String): MutableList<Question> {
        val jsonString = context.resources.openRawResource(R.raw.db).bufferedReader().use { it.readText() }
        val jsonObject = JSONObject(jsonString)
        val questionsArray = jsonObject.getJSONArray("questions")
        val questions: MutableList<Question> = mutableListOf()

        for (i in 0 until questionsArray.length()) {
            val questionJson = questionsArray.getJSONObject(i)
            if (questionJson.getString("mode") == mode) {
                val question = Question(
                    questionJson.getString("question"),
                    questionJson.getJSONArray("options").let { 0.until(it.length()).map { idx -> it.getString(idx) } },
                    questionJson.getString("answer")
                )
                questions.add(question)
            }
        }
        return questions
    }
}