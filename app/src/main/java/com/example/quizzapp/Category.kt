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
        supportActionBar?.hide();

        val Btn1 : ImageView = findViewById(R.id.View5);
        val Btn2 : ImageView = findViewById(R.id.View6);
        val Btn3 : ImageView = findViewById(R.id.View7);
        val Btn4 : ImageView = findViewById(R.id.View8);
        val Btn5 : ImageView = findViewById(R.id.View9);

        val intent: Intent = Intent(this, Questions::class.java);

        Btn1.setOnClickListener{
            intent.putExtra("name","a");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(intent);
        }
        Btn2.setOnClickListener{
            intent.putExtra("name","b");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        Btn3.setOnClickListener{
            intent.putExtra("name","c");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        Btn4.setOnClickListener{
            intent.putExtra("name","d");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        Btn5.setOnClickListener{
            intent.putExtra("name","e");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}