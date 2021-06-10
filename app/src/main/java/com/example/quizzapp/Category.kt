package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        supportActionBar?.hide();

        val startBtn :ImageButton =findViewById(R.id.startBtn);

        startBtn.setOnClickListener {
            val intent: Intent = Intent(this, Questions::class.java);
            startActivity(intent)
        }
    }


}