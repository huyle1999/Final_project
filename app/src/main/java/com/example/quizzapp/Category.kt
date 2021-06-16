package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView

class Category : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        val Btn1 : ImageView = findViewById(R.id.View5);
        val Btn2 : ImageView = findViewById(R.id.View6);
        val Btn3 : ImageView = findViewById(R.id.View7);
        val intent: Intent = Intent(this, Questions::class.java);

        Btn1.setOnClickListener{
            intent.putExtra("name1",Btn1.id.toString());
            startActivity(intent);
        }
        Btn2.setOnClickListener{
            intent.putExtra("name2",Btn2.id.toString());
            startActivity(intent);
        }
        Btn3.setOnClickListener{
            intent.putExtra("name3",Btn3.id.toString());
            startActivity(intent);
        }
    }
}