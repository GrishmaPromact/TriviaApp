package com.grishma.triviaapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.grishma.triviaapp.R
import com.grishma.triviaapp.data.db.QuizDao
import com.grishma.triviaapp.data.db.QuizRoomDatabase
import com.grishma.triviaapp.data.model.Quiz
import kotlinx.android.synthetic.main.fragment_quiz.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern

class QuizFragment : Fragment() {

    // the DAO to access database
    private var quizDao: QuizDao? = null
    private val NAME_VALIDATION_MSG = "Enter a valid name"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Get the custom view for this fragment layout
        val view = inflater!!.inflate(R.layout.fragment_quiz, container, false)
        // setup Database and get DAO
        val database = QuizRoomDatabase.getDatabase(requireContext())
        quizDao = database.quizDao()


        view.btnNext.setOnClickListener {
            if (isValidName(view.etName, true)) {

                val df: DateFormat = SimpleDateFormat("dd MMM, h:mm a")
                val date: String = df.format(Calendar.getInstance().getTime())
                Log.d("Hi::", "date is :: $date")
                val quiz = Quiz(view.etName.text.toString(), "", "", date)

                val intent = Intent(activity, FirstQuestionActivity::class.java)
                intent.putExtra("quiz_object", quiz)
                startActivity(intent)
                view.etName.text?.clear()
            }
        }

        // Return the fragment view/layout
        return view
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
    /**
     * Checks if the name is valid.
     * @param data - can be EditText or String
     * @param updateUI - if true and if data is EditText, the function sets error to the EditText
     * @return - true if the name is valid.
     */
    fun isValidName(editText: EditText, updateUI: Boolean = true): Boolean {
        val exp = "^[A-Za-z]+\$"
        /*
        * ^ beginning of the string,
        * [A-Za-z] search for alphabetical chars either they are CAPITALS or not,
        * + string contains at least one alphabetical char,
        * $  end of the string*/
        val pattern = Pattern.compile(exp)
        val matcher = pattern.matcher(editText.text.toString())
        var valid = true
        if (!matcher.matches()) {
            valid = false
        }

        // Set error if required
        if (updateUI) {
            val error: String? = if (valid) null else NAME_VALIDATION_MSG
            editText.error = error
        }

        return valid
    }
}

