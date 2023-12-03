package com.violetta.nbatriviagame.model

/**
 * Represents a trivia question with multiple choice answers.
 *
 * Class encapsulates the data for a single trivia question, including the question text,
 * a list of possible answers, and the index of the correct answer.
 *
 * @property text The text of the trivia question.
 * @property options A list of possible answers for the trivia question.
 * @property answer The correct answer to the trivia question.
 */
data class Question(
    val text: String,
    val options: List<String>,
    val answer: String
)
