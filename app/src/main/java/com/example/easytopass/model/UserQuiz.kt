package com.example.easytopass.model

data class UserQuiz(
    var rightAnswer: Int = 0,
    var wrongAnswer: Int = 0,
    val submitQuestions: MutableList<Boolean>,
    val indexSubmitAnswer: MutableList<Int>,
    var submitNumberQuestions: Int=0
)