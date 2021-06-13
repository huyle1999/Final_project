package com.example.quizzapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class DoneAdapter(private val context: Context,
                  private val info: DoneFeed
): BaseAdapter() {
    override fun getView(p0: Int, view: View?, viewGroup: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context);
        val statRow: View = layoutInflater.inflate(R.layout.donelist, viewGroup, false)

        statRow.findViewById<TextView>(R.id.q_number).text = "Attempted Questions: ${info.qNumbers}"
        statRow.findViewById<TextView>(R.id.correct).text = "Correct Answers : ${info.qCorrectAnswers}"
        statRow.findViewById<TextView>(R.id.score).text = "Score : ${info.Score}/100 "
        statRow.findViewById<TextView>(R.id.wrong).text = "Wrong Answers : ${info.qNegative}"

        return statRow
    }

    override fun getItem(p0: Int): Any {
        return  p0.toLong()
    }

    override fun getItemId(p0: Int): Long {
        return  p0.toLong()
    }

    override fun getCount(): Int {
        return 1
    }


}