package com.grishma.triviaapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.grishma.triviaapp.R
import com.grishma.triviaapp.data.model.Quiz
import kotlinx.android.synthetic.main.item_history.view.*

//Histrory Adapter to bind views
class HistoryItemAdapter(
    var context: Context,
    var items: List<Quiz>
): RecyclerView.Adapter<HistoryItemAdapter.HistoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)

        return HistoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val curHistoryItem = items[position]
        holder.itemView.tvGame.text = "GAME " +(position.plus(1)) + ": " + curHistoryItem.date
        holder.itemView.tvName.text = "Name : " + curHistoryItem.name
        holder.itemView.tvAns1.text = "Answer : " +curHistoryItem.ans1

        //split string with "," print values
        val separated: List<String> = curHistoryItem.ans2.split(",")
        var final = ""
        for (i in separated) {
            println(i)
            final += i
        }

        holder.itemView.tvAns2.text = "Answers :"+ final
    }

    inner class HistoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}




