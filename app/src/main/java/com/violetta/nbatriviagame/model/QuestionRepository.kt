package com.violetta.nbatriviagame.model

import DatabaseHelper
import android.content.Context
import android.database.Cursor
import android.util.Log

class QuestionRepository(private val context: Context) {

    private val dbHelper = DatabaseHelper(context)

    fun loadQuestions(mode: String): MutableList<Question> {
        val questions: MutableList<Question> = mutableListOf()
        dbHelper.openDatabase()

        val database = dbHelper.getDatabase()

        database?.let { db ->
            try {
                val questionsCursor: Cursor = db.rawQuery("SELECT * FROM Questions WHERE mode = \"$mode\"", null)
                Log.d("QuestionRepository", "Questions Cursor Count: ${questionsCursor.count}")


                val questionIdColumnIndex = questionsCursor.getColumnIndex("question_id")
                val questionTextColumnIndex = questionsCursor.getColumnIndex("question")
                val optionTextColumnIndex = questionsCursor.getColumnIndex("option_text")
                val optionsTextColumnIndex = questionsCursor.getColumnIndex("options")
                val answerTextColumnIndex = questionsCursor.getColumnIndex("answer")

                if (questionsCursor.moveToFirst()) {
                    do {
                        // Check if column indices are valid
                        if (questionIdColumnIndex != -1 && questionTextColumnIndex != -1 && optionTextColumnIndex != -1 && answerTextColumnIndex != -1) {
                            val questionId = questionsCursor.getInt(questionIdColumnIndex)
                            val questionText = questionsCursor.getString(questionTextColumnIndex)
                            val optionsText = questionsCursor.getString(optionsTextColumnIndex)
                            val optionsList = optionsText.split(",")
                            val answerText = questionsCursor.getString(answerTextColumnIndex)

                            val question = Question(questionId, questionText, optionsList, answerText)
                            questions.add(question)
                        } else {
                            Log.e("QuestionRepository", "Invalid column index")
                        }
                    } while (questionsCursor.moveToNext())
                }
                questionsCursor.close()
            } catch (e: Exception) {
                Log.e("QuestionRepository", "Error loading questions: ${e.message}")
            } finally {
                dbHelper.closeDatabase()
            }
        }

        Log.d("QuestionRepository", "Questions Count: ${questions.size}")
        return questions
    }
}
