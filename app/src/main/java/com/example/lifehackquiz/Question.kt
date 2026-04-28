package com.example.lifehackquiz

data class Question(
    val statement: String,
    val isHack: Boolean,  // true = Life Hack, false = Urban Myth
    val explanation: String
)