import android.content.Context
import android.util.Log
import com.violetta.nbatriviagame.model.Question
import android.database.sqlite.SQLiteException
import com.violetta.nbatriviagame.model.DatabaseHelper

class QuestionRepository{

    fun loadQuestions(context: Context, mode: String): MutableList<Question> {
        val questions: MutableList<Question> = mutableListOf()
        val dbHelper = DatabaseHelper(context)
        var dbOpened = false

        try {
            val db = dbHelper.openDatabase()
            dbOpened = true
            val questionsCursor = db.rawQuery("SELECT * FROM Questions WHERE mode = ?", arrayOf(mode))
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

                        // Query to get options for this question
                        val optionsCursor = db.rawQuery("SELECT option_text FROM Options WHERE question_id = ?", arrayOf(questionId.toString()))
                        val options = mutableListOf<String>()

                        if (optionsCursor.moveToFirst()) {
                            do {
                                options.add(optionsCursor.getString(questionIdColumnIndex))
                            } while (optionsCursor.moveToNext())
                        }
                        optionsCursor.close()

                        val question =
                            Question(questionText, options, answerText)
                        questions.add(question)
                    } else {
                        Log.e("QuestionRepository", "Invalid column index")
                    }
                } while (questionsCursor.moveToNext())
                questionsCursor.close()
            }
        } catch (e: SQLiteException) {
            Log.e("QuestionRepository", "Error loading questions", e)
        } finally {
            if (dbOpened) {
                dbHelper.close()
            }
        }

        Log.d("QuestionRepository", "Questions Count: ${questions.size}")
        return questions
    }
}