import android.content.Context
import android.util.Log
import com.violetta.nbatriviagame.model.Question
import android.database.sqlite.SQLiteException

class QuestionRepository{

    fun loadQuestions(context: Context, mode: String): MutableList<Question> {
        val questions: MutableList<Question> = mutableListOf()
        val dbHelper = DatabaseHelper(context)
        var dbOpened = false

        try {
            var optionsList:ArrayList<String> = arrayListOf()

            val db = dbHelper.openDatabase()
            dbOpened = true
            val questionsCursor =
                db.rawQuery("SELECT * FROM Questions WHERE mode = ?", arrayOf(mode))
            Log.d("QuestionRepository", "Questions Cursor Count: ${questionsCursor.count}")


            if (questionsCursor.moveToFirst()) {
                do {
                    val questionIdColumnIndex = questionsCursor.getColumnIndex("question_id")
                    val questionTextColumnIndex = questionsCursor.getColumnIndex("question")
                    val answerTextColumnIndex = questionsCursor.getColumnIndex("answer")

                    // Check if column indices are valid, reading all questions and add them into questions
                    if (questionIdColumnIndex != -1 && questionTextColumnIndex != -1 && answerTextColumnIndex != -1) {
                        val questionId = questionsCursor.getInt(questionIdColumnIndex)

                        val questionText = questionsCursor.getString(questionTextColumnIndex)

                        val answerText = questionsCursor.getString(answerTextColumnIndex)


                        val question =
                            Question(questionId, questionText, answerText)
                        questions.add(question)
                    } else {
                        Log.e("QuestionRepository", "Invalid column index")
                    }
                } while (questionsCursor.moveToNext())
                questionsCursor.close()
            }

            // for each question, adding options
            for (question in questions) {

                val optionsCursor =
                    db.rawQuery(
                        "SELECT * FROM Options WHERE question_id = ?",
                        arrayOf(question.questionId.toString())
                    )
                Log.d("QuestionRepository", "Options Cursor Count: ${optionsCursor.count}")


                if (optionsCursor.moveToFirst()) {
                    do {
                        val optionColumnIndex = optionsCursor.getColumnIndex("option_text")

                        // Check if column indices are valid
                        if (optionColumnIndex != -1) {
                            val option = optionsCursor.getString(optionColumnIndex)
                            optionsList.add(option)
                            question.addOptions(optionsList)
                        } else {
                            Log.e("QuestionRepository", "Invalid column index")
                        }

                    } while (optionsCursor.moveToNext())
                    optionsCursor.close()
                }
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