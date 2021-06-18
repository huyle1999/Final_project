package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide();

        val btn = findViewById<Button>(R.id.button);

        btn.setOnClickListener {
            val intent = Intent(this,Inputname::class.java )
            startActivity(intent)

        }
    }


}