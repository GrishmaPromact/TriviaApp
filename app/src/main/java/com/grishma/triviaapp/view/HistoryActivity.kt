package com.grishma.triviaapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.grishma.triviaapp.R
import com.grishma.triviaapp.adapter.HistoryItemAdapter
import com.grishma.triviaapp.viewmodel.QuizViewModel
import kotlinx.android.synthetic.main.activity_history.*

//History Adapter to show all history
class HistoryActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)

        //initialize adapter
        val adapter = HistoryItemAdapter(this, listOf())

        rvHistory.layoutManager = LinearLayoutManager(this)
        rvHistory.adapter = adapter

        //update vales of adapter
        viewModel.getAllQuizItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })
    }
}