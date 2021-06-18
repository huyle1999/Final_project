package com.example.quizzapp

import android.content.Intent
import android.os.Bundle
import android.sax.StartElementListener
import android.widget.*


import androidx.appcompat.app.AppCompatActivity

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        supportActionBar?.hide();

        val allItems: ArrayList<Items> = ArrayList();
        allItems.add(Items("Total Score", R.drawable.icon_15_trophy));
        allItems.add(Items("Total Test", R.drawable.group_25));
        allItems.add(Items("Previous Score", R.drawable.iconfinder_12));
        allItems.add(Items("Time Taken", R.drawable.group_24));

        val Grid: GridView = findViewById<GridView>(R.id.GridView);
        Grid.adapter = Adapter(this, allItems);

        Grid.setOnItemClickListener { adapterView, view, i, l ->
            val check1 = allItems[i];
            when(check1.name)
            {
                "Total Score"->
                    startActivity(Intent(this,totalscore::class.java))
                "Total Test"->
                        startActivity(Intent(this,totaltest::class.java))
                "Previous Score"->
                    startActivity(Intent(this,previous::class.java))
                "Time Taken"->
                        startActivity(Intent(this,timetaken::class.java))



            }
        }

        val intent = intent
        val name1 = intent.getStringExtra("name")
        val txt = findViewById<TextView>(R.id.john)
        txt.text = "Welcome to our quizzapp,"+" "+name1

        val nextBtn = findViewById<ImageButton>(R.id.next_btn);

        nextBtn.setOnClickListener {
            val intent: Intent = Intent(this, Category::class.java);
            startActivity(intent)
        }


    }
}
