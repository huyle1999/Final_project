package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val startBtn : Button = findViewById(R.id.startBtn);
        val intent: Intent = Intent(this, Questions::class.java);

        startBtn.setOnClickListener{
            startActivity(intent);
        }
    }
}