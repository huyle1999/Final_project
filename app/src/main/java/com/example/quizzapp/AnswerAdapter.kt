package com.example.quizzapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.security.AccessControlContext

class AnswerAdapter(private val context: Context,
                    val answers: ArrayList<String>) : BaseAdapter(){
    override fun getCount(): Int {
        return answers.count()
    }

    override fun getItem(position: Int): Any {
        return position.toLong()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(context);
        val answerRow: View = layoutInflater.inflate(R.layout.answers, parent, false);

        val answerNum = position + 1;
        answerRow.findViewById<TextView>(R.id.answer_text).text = "${answers[position]}"
        answerRow.findViewById<TextView>(R.id.answer_num).text = "${answerNum.toString()}";

        return answerRow
    }
//    override fun getCount(): Int {
//        return answers.count()
//    }
//
//    override fun getItem(position: Int): Any {
//        return position.toLong()
//    }
//
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }
//
//    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
//        val layoutInflater = LayoutInflater.from(context);
//        val answerRow: View = layoutInflater.inflate(R.layout.answers, viewGroup, false);
//
//        return answerRow
//    }


}