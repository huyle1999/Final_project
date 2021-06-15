package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class name : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
        supportActionBar?.hide();

        val btn = findViewById<ImageButton>(R.id.next_btn);
        val text = findViewById<EditText>(R.id.editTextTextPersonName);


        btn.setOnClickListener {
            val intent = Intent(this, Menu::class.java)
            intent.putExtra("name",text.text.toString());
            startActivity(intent)


        }
    }
}