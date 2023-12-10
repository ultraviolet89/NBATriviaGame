package com.violetta.nbatriviagame.model

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log
import com.violetta.nbatriviagame.R
import com.violetta.nbatriviagame.model.Question
import java.io.IOException
import java.io.InputStream

class DatabaseHelper(private val context: Context) {

    private val DATABASE_NAME = "nba.db"
    private var database: SQLiteDatabase? = null

    fun openDatabase() {
        if (database != null && database?.isOpen == true) {
            return
        }
        val dbPath: InputStream = context.applicationContext.resources.openRawResource(R.raw.nba)
        database = try {
            SQLiteDatabase.openDatabase("", null, SQLiteDatabase.OPEN_READWRITE)
        } catch (e: SQLiteException) {
            null
        }
    }

    fun closeDatabase() {
        database?.close()
    }


    fun getDatabase(): SQLiteDatabase? {
        return database
    }
    fun copyDatabase() {
        val dbPath = context.getDatabasePath(DATABASE_NAME)

        if (!dbPath.exists()) {
            val inputStream = context.resources.openRawResource(R.raw.nba)
            val outputStream = dbPath.outputStream()

            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
        }
    }

    fun loadQuestions(mode: String): MutableList<Question> {
        val questions: MutableList<Question> = mutableListOf()
        openDatabase()

        try {
            database?.let { db ->
                val questionsCursor: Cursor = db.rawQuery("SELECT * FROM Questions WHERE mode = ?", arrayOf(mode))
                Log.d("QuestionRepository", "Questions Cursor Count: ${questionsCursor.count}")

                if (questionsCursor.moveToFirst()) {
                    do {
                        val questionIdColumnIndex = questionsCursor.getColumnIndex("question_id")
                        val questionTextColumnIndex = questionsCursor.getColumnIndex("question")
                        val answerTextColumnIndex = questionsCursor.getColumnIndex("answer")

                        // Check if column indices are valid
                        if (questionIdColumnIndex != -1 && questionTextColumnIndex != -1 && answerTextColumnIndex != -1) {
                            val questionId = questionsCursor.getInt(questionIdColumnIndex)
                            val questionText = questionsCursor.getString(questionTextColumnIndex)
                            val answerText = questionsCursor.getString(answerTextColumnIndex)

                            val question = Question(questionId.toString(), listOf(questionText), answerText)
                            questions.add(question)
                        } else {
                            Log.e("QuestionRepository", "Invalid column index")
                        }
                    } while (questionsCursor.moveToNext())
                }
                questionsCursor.close()
            }
        } catch (e: IOException) {
            Log.e("QuestionRepository", "Error opening database")
        }

        closeDatabase()
        Log.d("QuestionRepository", "Questions Count: ${questions.size}")
        return questions
    }
}
