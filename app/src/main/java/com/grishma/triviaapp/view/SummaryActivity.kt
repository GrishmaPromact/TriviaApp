package com.grishma.triviaapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.grishma.triviaapp.R
import com.grishma.triviaapp.data.model.Quiz
import kotlinx.android.synthetic.main.activity_summary.*

//Show summary of current added item
class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        //get quiz object via intent
        val quiz = intent.getSerializableExtra("quiz_object") as? Quiz

        tvName.text = "Hello " + quiz?.name +","
        tvAns1.text = "Answer : " + quiz?.ans1

        //split string with "," print values
        val separated: List<String> = quiz?.ans2.toString().split(",")
        var final = ""
        for (i in separated) {
            println(i)
            final += i
        }
        tvAns2.text = "Answers : " +final

        //finish button on click listener
        btnFinish.setOnClickListener {
            finish()
        }

        //history button on click listener
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}


