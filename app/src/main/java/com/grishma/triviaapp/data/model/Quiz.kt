package com.grishma.triviaapp.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

/**
 * Created by grishma on 8/7/18.
 *
 * Entity class to store in Room Database
 */
@Entity(tableName = "quiz")
class Quiz(var name : String, var ans1: String, var ans2 : String, var date : String,
             @PrimaryKey(autoGenerate = true)
             val id: Int = 0) :Serializable {

}
