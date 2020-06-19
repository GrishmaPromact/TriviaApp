package com.grishma.triviaapp.data.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.grishma.triviaapp.data.model.Quiz

/**
 * Created by grishma on 18/6/20.
 * The Data Access Object for Phrase entity operations in database.
 */
@Dao
interface QuizDao {

    /**
     * Get all quiz in database ordered by ASC
     * @return a list with all quiz
     */
    @Query("SELECT * FROM quiz ORDER BY id ASC")
    fun allQuiz(): LiveData<MutableList<Quiz>>


    /**
     * Function to insert a quiz in room database
     * @param quiz to be inserted in database
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(quiz: Quiz)

}
