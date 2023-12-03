package com.violetta.nbatriviagame.model

import android.content.Context
import com.violetta.nbatriviagame.R
import org.json.JSONObject

/**
 * Repository for managing trivia questions.
 *
 * Class provides functionality to load trivia questions from a data source.
 * Intermediary between the data source and the application logic.
 *
 * @constructor Creates a QuestionRepository instance.
 */
class QuestionRepository {
    /**
     * Loads questions for the trivia game.
     *
     * Retrieves a list of questions based on the specified mode.
     * Allows accesses of a data source, such as a local database or a JSON file, to obtain the questions.
     *
     * @param context The context used for accessing resources.
     * @param mode The mode of the trivia game for which questions are loaded.
     * @return A list of questions for the specified mode.
     */
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