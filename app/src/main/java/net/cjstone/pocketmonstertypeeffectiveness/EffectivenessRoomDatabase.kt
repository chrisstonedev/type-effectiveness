package net.cjstone.pocketmonstertypeeffectiveness

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

// Annotates class to be a Room Database with a table (entity) of the Effectiveness class
@Database(entities = [Effectiveness::class], version = 1, exportSchema = false)
abstract class EffectivenessRoomDatabase : RoomDatabase() {

    abstract fun effectivenessDao(): EffectivenessDao

    private class EffectivenessDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)


            INSTANCE?.let { database ->
                scope.launch {
                    val effectivenessDao = database.effectivenessDao()

                    effectivenessDao.deleteAll()

                    // Add sample words.
                    var word = Effectiveness("Hello", "def", 1f)
                    effectivenessDao.insert(word)
                    word = Effectiveness("World!", "def", 1f)
                    effectivenessDao.insert(word)

                    // TODO: Add your own words!
                    word = Effectiveness("TODO!", "dat", 0.5f)
                    effectivenessDao.insert(word)
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: EffectivenessRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): EffectivenessRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EffectivenessRoomDatabase::class.java,
                    "effectiveness_database"
                )
                    .addCallback(EffectivenessDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}