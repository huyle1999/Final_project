package com.example.quizzapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class Adapter(private val context:Context,
private val AllItems: ArrayList<Items>):BaseAdapter() {
    override fun getView(p0: Int, view: View?, viewGroup: ViewGroup?): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(context);
        val mainRow: View = layoutInflater.inflate(R.layout.itemlist, viewGroup, false);

        val Text: TextView = mainRow.findViewById(R.id.stat_text);
        val Img: ImageView = mainRow.findViewById(R.id.stat_image);

        Text.text = AllItems[p0].name;
        Img.setImageResource(AllItems[p0].image)
        return mainRow
    }

    override fun getItem(p0: Int): Any {
        return p0.toLong();
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong();
    }

    override fun getCount(): Int {
        return AllItems.count();
    }

}