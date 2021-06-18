package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class totalscore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_totalscore)
        supportActionBar?.hide();
        val intent = intent
        var Score = intent.getStringExtra("Score")
        if (Score==null){
            var i:Int =0
            Score = i.toString()
        }
        val txt3 = findViewById<TextView>(R.id.textView8)
        txt3.text="Total Score :"+Score
    }
}