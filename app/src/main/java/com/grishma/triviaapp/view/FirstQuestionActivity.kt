package com.grishma.triviaapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.grishma.triviaapp.R
import com.grishma.triviaapp.data.model.Quiz
import kotlinx.android.synthetic.main.activity_first_question.*

//First question Activity of quiz
class FirstQuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_question)

        //get quiz object using intent
        var quiz = intent.getSerializableExtra("quiz_object") as? Quiz
        var ans1 = ""

        //radio button checked change listener
        radioGroup.setOnCheckedChangeListener { group, checkedId ->

            ans1 = (findViewById<View>(checkedId) as RadioButton).text
                .toString()

        }
        ans1 = radioBtn1.text.toString() //by default first radio button selected

        //next button on click listener
        btnNext1.setOnClickListener {
            quiz?.ans1 = ans1
            val intent = Intent(this, SecondQuestionActivity::class.java)
            intent.putExtra("quiz_object", quiz)
            startActivity(intent)

            finish()
        }
    }
}