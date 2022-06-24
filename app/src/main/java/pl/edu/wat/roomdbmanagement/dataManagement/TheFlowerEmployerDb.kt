package pl.edu.wat.roomdbmanagement.dataManagement

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 Klasa abstrakcyjna służąca jako punkt dostępu do bazy danych
 dla utworzonej aplikacji.
 */

@Database(entities = [TheFlowerEmployer::class], version = 1, exportSchema = false)
abstract class TheFlowerEmployerDb : RoomDatabase() {

    abstract fun theFlowerEmployerDao() : TheFlowerEmployerDao

    companion object{
        @Volatile
        private var INSTANCE: TheFlowerEmployerDb? = null

        fun getDb(context : Context) : TheFlowerEmployerDb{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TheFlowerEmployerDb::class.java,
                    "TheFlowerEmployer_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}