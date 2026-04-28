// ReviewActivity.kt
package com.example.lifehackquiz

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val rvReview = findViewById<RecyclerView>(R.id.rvReview)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Set up RecyclerView
        rvReview.layoutManager = LinearLayoutManager(this)
        rvReview.adapter = ReviewAdapter(QuestionBank.questions)

        btnBack.setOnClickListener {
            finish()
        }
    }
}