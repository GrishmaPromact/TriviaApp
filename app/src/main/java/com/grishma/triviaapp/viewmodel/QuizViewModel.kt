package com.grishma.triviaapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.grishma.triviaapp.data.db.QuizRoomDatabase
import com.grishma.triviaapp.data.model.Quiz

/**
 * Created by grishma on 19/06/20.
 */

class QuizViewModel(app: Application): AndroidViewModel(app) {

    private val database = QuizRoomDatabase.getDatabase(app) //get database
    private val quizDao = database.quizDao() //get dao class

    fun insert(item: Quiz) = quizDao.insert(item) //insert quiz item to database

    fun getAllQuizItems() = quizDao.allQuiz() //get all quiz items as a list

    companion object {
        private const val TAG = "QuizViewModel"
    }
}