package com.grishma.triviaapp.data.db

import android.content.Context

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.grishma.triviaapp.data.model.Quiz

/**
 * Created by  grishma on 18/6/20.
 */
@Database(entities = [Quiz::class], version = 1)
abstract class QuizRoomDatabase : RoomDatabase() {

    /**
     * This is the Quiz data access object instance
     * @return the dao to phrase database operations
     */
    abstract fun quizDao(): QuizDao

    companion object {

        /**
         * This is just for singleton pattern
         */
        private var INSTANCE: QuizRoomDatabase? = null

        fun getDatabase(context: Context): QuizRoomDatabase {
            if (INSTANCE == null) {
                synchronized(QuizRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get QuizRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                                QuizRoomDatabase::class.java, "quiz_database")
                                .allowMainThreadQueries()
                                .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }
}
