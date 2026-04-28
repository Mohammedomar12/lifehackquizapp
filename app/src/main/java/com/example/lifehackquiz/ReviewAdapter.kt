package com.example.lifehackquiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReviewAdapter(private val questions: List<Question>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {

    class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvQuestionNum: TextView = itemView.findViewById(R.id.tvQuestionNum)
        val tvStatement: TextView = itemView.findViewById(R.id.tvStatement)
        val tvCorrectAnswer: TextView = itemView.findViewById(R.id.tvCorrectAnswer)
        val tvExplanation: TextView = itemView.findViewById(R.id.tvExplanation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val question = questions[position]

        holder.tvQuestionNum.text = "Question ${position + 1}"
        holder.tvStatement.text = question.statement
        holder.tvCorrectAnswer.text = if (question.isHack) {
            "✓ Correct Answer: Life Hack (True)"
        } else {
            "✗ Correct Answer: Urban Myth (False)"
        }
        holder.tvExplanation.text = question.explanation
    }

    override fun getItemCount() = questions.size
}