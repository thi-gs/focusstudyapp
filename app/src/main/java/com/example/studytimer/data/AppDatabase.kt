import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.studytimer.data.StudySession
import com.example.studytimer.data.StudySessionDao
import com.example.studytimer.data.User
import com.example.studytimer.data.UserDao

@Database(entities = [User::class, StudySession::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun studySessionDao(): StudySessionDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "study_timer_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}
