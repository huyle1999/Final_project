package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class previous : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_previous)

        supportActionBar?.hide();
        val intent = intent
        var Score = intent.getStringExtra("Score")
        if (Score==null){
            var i:Int =0
            Score = i.toString()
        }
        val txt3 = findViewById<TextView>(R.id.textView8)
        txt3.text="Score :"+Score+"/100"
    }
}