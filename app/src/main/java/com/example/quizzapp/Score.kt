package com.example.quizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)


        val qNumbers = intent.getStringExtra("qNumbers")
        val qCorrectAnswers = intent.getStringExtra("qCorrectAnswers")
        val qAttempted = intent.getStringExtra("qAttempted")
        val qNegative = intent.getStringExtra("qNegative")
        val Score = intent.getStringExtra("Score")



        //val txt1 = findViewById<TextView>(R.id.q_number)
        val txt1 = findViewById<TextView>(R.id.q_number)
        txt1.text="Number of questions :"+qNumbers
        val txt2 = findViewById<TextView>(R.id.correct)
        txt2.text="Correct Answers :"+qCorrectAnswers
        val txt3 = findViewById<TextView>(R.id.score)
        txt3.text="Score :"+Score+"/100"
        val txt4 = findViewById<TextView>(R.id.wrong)
        txt4.text="Wrong Answers :"+qNegative
        val txt5 = findViewById<ImageButton>(R.id.restart)

        txt5.setOnClickListener{
            val intent = Intent(this,Category::class.java )


            startActivity(intent);
        }



        //statRow.findViewById<TextView>(R.id.q_number).text = "Attempted Questions: ${info.qNumbers}"

        //statRow.findViewById<TextView>(R.id.correct).text = "Correct Answers : ${info.qCorrectAnswers}"
        //statRow.findViewById<TextView>(R.id.score).text = "Score : ${info.Score}/100 "
        //statRow.findViewById<TextView>(R.id.wrong).text = "Wrong Answers : ${info.qNegative}"
    }
}
