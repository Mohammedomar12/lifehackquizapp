package com.example.lifehackquiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class QuizActivity : AppCompatActivity() {

    private lateinit var tvQuestionNumber: TextView
    private lateinit var tvScore: TextView
    private lateinit var tvQuestion: TextView
    private lateinit var tvFeedback: TextView
    private lateinit var btnHack: Button
    private lateinit var btnMyth: Button
    private lateinit var btnNext: Button
    private lateinit var cardQuestion: CardView

    private var currentQuestionIndex = 0
    private var score = 0
    private val questions = QuestionBank.questions
    private val userAnswers = mutableListOf<Pair<Question, Boolean>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        tvQuestionNumber = findViewById(R.id.tvQuestionNumber)
        tvScore = findViewById(R.id.tvScore)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvFeedback = findViewById(R.id.tvFeedback)
        btnHack = findViewById(R.id.btnHack)
        btnMyth = findViewById(R.id.btnMyth)
        btnNext = findViewById(R.id.btnNext)
        cardQuestion = findViewById(R.id.cardQuestion)

        btnHack.setOnClickListener { checkAnswer(true) }
        btnMyth.setOnClickListener { checkAnswer(false) }
        btnNext.setOnClickListener { loadNextQuestion() }

        loadQuestion()
    }

    private fun loadQuestion() {
        if (currentQuestionIndex < questions.size) {
            val question = questions[currentQuestionIndex]

            tvQuestionNumber.text = "Question ${currentQuestionIndex + 1} of ${questions.size}"
            tvQuestion.text = question.statement
            tvScore.text = "Score: $score"

            btnHack.isEnabled = true
            btnMyth.isEnabled = true
            tvFeedback.visibility = View.GONE
            btnNext.visibility = View.GONE
        } else {
            navigateToScoreScreen()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val question = questions[currentQuestionIndex]
        val isCorrect = userAnswer == question.isHack

        if (isCorrect) {
            score++
            tvScore.text = "Score: $score"
        }

        userAnswers.add(Pair(question, isCorrect))

        tvFeedback.text = question.explanation
        tvFeedback.visibility = View.VISIBLE

        btnHack.isEnabled = false
        btnMyth.isEnabled = false

        btnNext.visibility = View.VISIBLE
    }

    private fun loadNextQuestion() {
        currentQuestionIndex++
        loadQuestion()
    }

    private fun navigateToScoreScreen() {
        val intent = Intent(this, ScoreActivity::class.java)
        intent.putExtra("SCORE", score)
        intent.putExtra("TOTAL", questions.size)
        startActivity(intent)
        finish()
    }
}