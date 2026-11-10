package com.example.lifehackmyth

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    private val TAG = "ScoreScreen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 5)

        val tvTotalScore = findViewById<TextView>(R.id.tvTotalScore)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        tvTotalScore.text = "$score / $total Correct"

        // Personalised feedback based on score
        val message = when {
            score == total -> {
                Log.d(TAG, "Master Hacker level")
                "Master Hacker! 🏆 You know every hack from myth! Perfect!"
            }
            score >= 3 -> {
                Log.d(TAG, "Great job level")
                "Great job! 💡 You're pretty savvy at spotting myths!"
            }
            score >= 2 -> {
                Log.d(TAG, "Not bad level")
                "Not bad! Keep practicing your common sense!"
            }
            else -> {
                Log.d(TAG, "Stay safe level")
                "Stay Safe Online! ⚠️ Many myths tricked you - keep learning!"
            }
        }
        tvMessage.text = message

        // Review button logic - Shows all statements and correct explanations
        btnReview.setOnClickListener {
            Log.d(TAG, "Review button clicked")
            val reviewText = """
                REVIEW ALL HACKS & MYTHS:

                1. Vinegar removes coffee stains -> REAL HACK
                Explanation: Acidic reaction cleans safely.

                2. Spoon in champagne -> MYTH
                Explanation: Does nothing, needs stopper.

                3. Frozen grapes to chill wine -> REAL HACK
                Explanation: Chills without dilution.

                4. Rice fixes wet phone -> MYTH
                Explanation: Can damage phone, use silica.

                5. Walnut on furniture scratch -> REAL HACK
                Explanation: Natural oils hide scratch.

                Your Score: $score/$total
            """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("Review - All Answers")
                .setMessage(reviewText)
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        btnRestart.setOnClickListener {
            Log.d(TAG, "Restarting quiz")
            finish() // Go back to MainActivity
        }
    }
}
