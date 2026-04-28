package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 10)

        val tvFinalScore = findViewById<TextView>(R.id.tvFinalScore)
        val tvFeedbackMessage = findViewById<TextView>(R.id.tvFeedbackMessage)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnRestart = findViewById<Button>(R.id.btnRestart)

        tvFinalScore.text = "Your Score: $score/$total"

        tvFeedbackMessage.text = when {
            score == total -> "Master Hacker! Perfect score!"
            score >= total * 0.8 -> "Excellent! You're very knowledgeable!"
            score >= total * 0.6 -> "Good job! You know your stuff!"
            score >= total * 0.4 -> "Not bad! Keep practicing!"
            else -> "Keep learning! Try again!"
        }

        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity(intent)
        }

        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}