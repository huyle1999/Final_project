package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class totaltest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_totaltest)
        supportActionBar?.hide();
        val intent = intent
        var num = intent.getStringExtra("num")
        if (num==null){
            var i:Int =0
            num = i.toString()
        }
        val txt3 = findViewById<TextView>(R.id.textView8)
        txt3.text="Congra, You have done: "+num+" test"
    }
}