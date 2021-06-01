package com.example.quizzapp

class Items(val name: String, val image: Int);

class AllResults(
    val results: List<ResultFeed>,
    val respone_code: Int
)

class QuizResults(
    val results: String
)

class ResultFeed(
    val category: String,
    val type: String,
    val difficulty: String,
    val question: String,
    val correct_answer: String,
    val incorrect_answer: ArrayList<String>
)

class JoinedFeed(
    val questions: ArrayList<String>,
    val answer: ArrayList<ArrayList<String>>,
    val correct_answer: ArrayList<String>
)