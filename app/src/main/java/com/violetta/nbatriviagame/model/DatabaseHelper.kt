
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.io.FileOutputStream


class DatabaseHelper(private val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "nba.db"
        private const val DATABASE_VERSION = 1
    }

    init {
        copyDatabase()
    }

    fun openDatabase(): SQLiteDatabase {
        val dbPath = context.getDatabasePath(DATABASE_NAME)
        return SQLiteDatabase.openDatabase(dbPath.path, null, SQLiteDatabase.OPEN_READWRITE)
    }

    private fun copyDatabase(){
        val dbPath = context.getDatabasePath(DATABASE_NAME)
        if(!dbPath.exists()){
            dbPath.parentFile?.mkdirs()
            val inputStream = context.assets.open(DATABASE_NAME)
            val outputStream = FileOutputStream(dbPath)
            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
        }
    }
    override fun onCreate(db: SQLiteDatabase) {

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}
