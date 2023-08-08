package cl.awakelab.ejercicioindividual8modulo6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = [RazaEntity::class], version=1)
abstract class RazaDatabase: RoomDatabase() {

    abstract fun getRazaDao(): RazaDao

    companion object {
        @Volatile
        private var INSTANCE: RazaDatabase? = null

        fun getDatabase(context: Context): RazaDatabase {
            val tempInstance = INSTANCE
            if(tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RazaDatabase::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance
            }

        }

    }


}