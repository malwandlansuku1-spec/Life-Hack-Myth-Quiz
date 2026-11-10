package com.example.lifehackmyth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// Data class to hold each hack/myth statement
data class Question(
    val statement: String,
    val isHack: Boolean, // true = real hack, false = myth
    val explanation: String
)

class FlashcardActivity : AppCompatActivity() {
    private val TAG = "FlashcardLogic"
    private var currentIndex = 0
    private var score = 0

    // List of 5 questions - Looping through this with a loop logic
    private val questions = listOf(
        Question("White vinegar and baking soda removes coffee stains from mugs - True life hack", true, "True! Vinegar + baking soda is acidic and breaks down coffee oils safely."),
        Question("Putting a spoon in an open champagne bottle keeps it fizzy overnight", false, "Myth! Spoon does nothing. Use a proper champagne stopper to keep pressure."),
        Question("Freezing grapes to chill wine without diluting it", true, "Real time-saver! Frozen grapes chill wine and you can eat them after."),
        Question("Putting your wet phone in rice completely fixes water damage", false, "Myth! Rice is ineffective and can cause damage. Power off and use silica gel or professional repair."),
        Question("Rubbing walnut on scratched wooden furniture hides the scratch", true, "True! Natural oils in walnut darken and fill light scratches safely.")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flashcard)

        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val tvFeedback = findViewById<TextView>(R.id.tvFeedback)
        val tvProgress = findViewById<TextView>(R.id.tvProgress)
        val btnHack = findViewById<Button>(R.id.btnHack)
        val btnMyth = findViewById<Button>(R.id.btnMyth)
        val btnNext = findViewById<Button>(R.id.btnNext)

        // Function to display current question using loop concept
        fun loadQuestion() {
            if (currentIndex < questions.size) {
                val q = questions[currentIndex]
                tvQuestion.text = q.statement
                tvProgress.text = "Question ${currentIndex + 1} of ${questions.size}"
                tvFeedback.text = ""
                btnHack.isEnabled = true
                btnMyth.isEnabled = true
                btnNext.isEnabled = false
                Log.d(TAG, "Displaying question $currentIndex: ${q.statement}")
            }
        }

        loadQuestion()

        // Answer logic - Hack (True) button
        btnHack.setOnClickListener {
            val q = questions[currentIndex]
            val isCorrect = q.isHack == true
            if (isCorrect) {
                score++
                tvFeedback.text = "Correct! That's a real time-saver! 🎉\n${q.explanation}"
                Log.d(TAG, "Correct answer! Score now $score")
            } else {
                tvFeedback.text = "Wrong! That's just an urban myth. ❌\n${q.explanation}"
                Log.d(TAG, "Wrong answer, score stays $score")
            }
            btnHack.isEnabled = false
            btnMyth.isEnabled = false
            btnNext.isEnabled = true
        }

        // Answer logic - Myth (False) button
        btnMyth.setOnClickListener {
            val q = questions[currentIndex]
            val isCorrect = q.isHack == false
            if (isCorrect) {
                score++
                tvFeedback.text = "Correct! You spotted the myth! 🕵️\n${q.explanation}"
                Log.d(TAG, "Correct answer! Score now $score")
            } else {
                tvFeedback.text = "Wrong! That one is actually true! ✅\n${q.explanation}"
                Log.d(TAG, "Wrong answer, score stays $score")
            }
            btnHack.isEnabled = false
            btnMyth.isEnabled = false
            btnNext.isEnabled = true
        }

        // Next button - Loop to next question
        btnNext.setOnClickListener {
            currentIndex++ // Move to next question in loop
            if (currentIndex < questions.size) {
                // Loop continues
                Log.d(TAG, "Moving to next question index $currentIndex")
                loadQuestion()
            } else {
                // Loop finished - navigate to Score Screen
                Log.d(TAG, "All questions answered. Final score $score. Navigating to Score Screen")
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }
}
