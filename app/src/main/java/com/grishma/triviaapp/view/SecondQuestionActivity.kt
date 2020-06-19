package com.grishma.triviaapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.grishma.triviaapp.R
import com.grishma.triviaapp.data.model.Quiz
import com.grishma.triviaapp.viewmodel.QuizViewModel
import kotlinx.android.synthetic.main.activity_second_question.*

class SecondQuestionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_question)
        //get viewmodel class
        val viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        //get quiz object via intent
        var quiz = intent.getSerializableExtra("quiz_object") as? Quiz

        var text1: String? = ""
        var text2: String? = ""
        var text3: String? = ""
        var text4: String? = ""

        //checkbox1 check change listener
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                text1 = checkBox1.text.toString()
                Log.e("Hi", "check box value : $text1")
            }
        }

        //checkbox2 check change listener
        checkBox2.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                text2 = checkBox2.text.toString()
                Log.e("Hi", "check box value : $text2")
            }
        }

        //checkbox3 check change listener
        checkBox3.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                text3 = checkBox3.text.toString()
                Log.e("Hi", "check box value : $text3")
            }
        }

        //checkbox4 check change listener
        checkBox4.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                text4 = checkBox4.text.toString()
                Log.e("Hi", "check box value : $text4")
            }
        }


        //next button on click listener
        btnNext2.setOnClickListener {
            if (!checkBox1.isChecked && !checkBox2.isChecked && !checkBox3.isChecked && !checkBox4.isChecked) {
                //check if atleast one checkbox is clicked or not
                Toast.makeText(this, "Please select at least 1 answer!!!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val ans2: String = "$text1 , $text2 , $text3 , $text4"
                Log.e("Hi", "check box value : $ans2")
                quiz?.ans2 = ans2

                if (quiz != null) {
                    viewModel.insert(quiz) //insert quiz object to database
                }

                val intent = Intent(this, SummaryActivity::class.java)
                intent.putExtra("quiz_object", quiz) //pass quiz object
                startActivity(intent)

                finish()
            }
        }
    }

}
