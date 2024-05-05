package com.example.talkinggata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class LivePet : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_pet)

        // Declaring and linking variables
        val feedBtn = findViewById<Button>(R.id.feedBtn)
        val cleanBtn = findViewById<Button>(R.id.cleanBtn)
        val playBtn = findViewById<Button>(R.id.playBtn)
        val fedStat = findViewById<TextView>(R.id.fedStat)
        val cleanStat = findViewById<TextView>(R.id.cleanStat)
        val boredStat = findViewById<TextView>(R.id.boredStat)
        val petImage = findViewById<ImageView>(R.id.petImage)

        // setting starting image
        petImage.setImageResource(R.drawable.homescreen)


        feedBtn.setOnClickListener {
            // Log that the feed button is clicked
            Log.d("LivePet", "Feed button clicked")
            // Setting image to the feed image
            petImage.setImageResource(R.drawable.dogeating)
            // Get the current integer value from the TextView
            val currentFedValue = fedStat.text.toString().toInt()
            // adding 5 to the hunger stat
            val newFedValue = currentFedValue + 5
            // Log the new clean value
            Log.d("LivePet", "New fed value: $newFedValue")
            // updating the textview for the user
            fedStat.text = newFedValue.toString()
            // Restore the image to the starting image after a delay of 2 seconds
            petImage.postDelayed({
                petImage.setImageResource(R.drawable.homescreen)
            }, 2000)
        }

        cleanBtn.setOnClickListener {
            // Log that the clean button is clicked
            Log.d("LivePet", "clean button clicked")
            // Setting image to the clean image
            petImage.setImageResource(R.drawable.dogclean)
            // Get the current integer value from the TextView
            val currentCleanValue = cleanStat.text.toString().toInt()
            // adding 5 to the hunger stat
            val newCleanValue = currentCleanValue + 5
            // updating the textview for the user
            cleanStat.text = newCleanValue.toString()
            // Log the new clean value
            Log.d("LivePet", "New clean value: $newCleanValue")
            // Restore the image to the starting image after a delay of 2 seconds
            petImage.postDelayed({
                petImage.setImageResource(R.drawable.homescreen)
            }, 2000)
        }

        playBtn.setOnClickListener {
            // Log that the play button is clicked
            Log.d("LivePet", "play button clicked")
            // Setting image to the clean image
            petImage.setImageResource(R.drawable.dogplaying)
            // Get the current integer value from the TextView
            val currentBoredValue = boredStat.text.toString().toInt()
            // adding 5 to the hunger stat
            val newBoredValue = currentBoredValue + 5
            // Log the new bored value
            Log.d("LivePet", "New happy value: $newBoredValue")
            // updating the textview for the user
            boredStat.text = newBoredValue.toString()
            // Restore the image to the starting image after a delay of 2 seconds
            petImage.postDelayed({
                petImage.setImageResource(R.drawable.homescreen)
            }, 2000)
        }



        // creating a runnable that will decrease the fed value every 25 seconds
        val decreaseFedRunnable = object : Runnable {
            override fun run() {
                // Log that a new time starts
                Log.d("LivePet", "New time starts for decreasing fed value")
                // Get the current integer value from the TextView
                val currentFedValue = fedStat.text.toString().toInt()
                // Decrease the fed value by 5
                val newFedValue = currentFedValue - 5
                // Log that the fed stat has decreased by 5
                Log.d("LivePet", "Fed stat decreased by 5")
                // Update the TextView with the new fed value
                fedStat.text = newFedValue.toString()
                // Schedule the next execution of this Runnable after 25 seconds
                fedStat.postDelayed(this, 25000)
            }
        }

// Start the continuous decrease of fed value
        fedStat.post(decreaseFedRunnable)

// creating a runnable that will decrease the clean value every 25 seconds
        val decreaseCleanRunnable = object : Runnable {
            override fun run() {
                // Log that a new time starts
                Log.d("LivePet", "New time starts for decreasing clean value")
                // Get the current integer value from the TextView
                val currentCleanValue = cleanStat.text.toString().toInt()
                // Decrease the clean value by 5
                val newCleanValue = currentCleanValue - 5
                // Log that the clean stat has decreased by 5
                Log.d("LivePet", "clean stat decreased by 5")
                // Update the TextView with the new clean value
                cleanStat.text = newCleanValue.toString()
                // Schedule the next execution of this Runnable after 25 seconds
                cleanStat.postDelayed(this, 25000)
            }
        }

// Start the continuous decrease of clean value
        cleanStat.post(decreaseCleanRunnable)

// creating a runnable that will decrease the boredom value every 25 seconds
        val decreaseBoredRunnable = object : Runnable {
            override fun run() {
                // Log that a new time starts
                Log.d("LivePet", "New time starts for decreasing fed value")
                // Get the current integer value from the TextView
                val currentBoredValue = boredStat.text.toString().toInt()
                // Decrease the bored value by 5
                val newBoredValue = currentBoredValue - 5
                // Log that the happy stat has decreased by 5
                Log.d("LivePet", "happy stat decreased by 5")
                // Update the TextView with the new bored value
                boredStat.text = newBoredValue.toString()
                // Schedule the next execution of this Runnable after 25 seconds
                boredStat.postDelayed(this, 25000)
            }
        }

// Start the continuous decrease of bored value
        boredStat.post(decreaseBoredRunnable)



    }
}




