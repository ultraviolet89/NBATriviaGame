
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.util.Log
import com.violetta.nbatriviagame.R
import com.violetta.nbatriviagame.model.Question
import java.io.IOException


class DatabaseHelper(private val context: Context) {

    private val DATABASE_NAME = "nba.db"
    private var database: SQLiteDatabase? = null

    fun openDatabase() {
        if (database != null && database?.isOpen == true) {
            return
        }
        val dbPath = context.getDatabasePath(DATABASE_NAME)

        if (!dbPath.exists()) {
            copyDatabase()
        }

        database = try {
            SQLiteDatabase.openDatabase(dbPath.path, null, SQLiteDatabase.OPEN_READWRITE)
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

}
