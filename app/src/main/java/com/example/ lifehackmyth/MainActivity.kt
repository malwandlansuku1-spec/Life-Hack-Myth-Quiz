package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

// MainActivity: Welcome Screen - Entry point of the app
class MainActivity : AppCompatActivity() {
    private val TAG = "WelcomeScreen"
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Welcome screen loaded - App started")

        val btnStart = findViewById<Button>(R.id.btnStart)
        
        // Logic: When user clicks Start, navigate to Flashcard Question Screen
        btnStart.setOnClickListener {
            Log.d(TAG, "Start button clicked - Navigating to quiz")
            val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
        }
    }
}
