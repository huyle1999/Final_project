package com.example.quizzapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class timetaken : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timetaken)
        supportActionBar?.hide();
        val txt3 = findViewById<TextView>(R.id.textView8)
        txt3.text="Xin lỗi,chúng tôi sẽ cập nhập sau"

    }
}