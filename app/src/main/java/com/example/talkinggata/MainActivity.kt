package com.example.talkinggata

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring variables and connecting frontend to backend code
        val startbtn = findViewById<Button>(R.id.startbtn)
        val mainimage = findViewById<ImageView>(R.id.mainimage)

        // setting starting image
        mainimage.setImageResource(R.drawable.homescreen)

        //waiting for start button to be clicked
        startbtn.setOnClickListener {
            // create the explicit intent to link the second page to this
            val intent = Intent(this, LivePet::class.java)

            // starting the activity stored in intent variable which is the LivePet page
            startActivity(intent)


        }
    }
}