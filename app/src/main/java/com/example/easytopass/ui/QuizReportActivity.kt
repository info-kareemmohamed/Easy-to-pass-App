package com.example.easytopass.ui

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.easytopass.R
import com.example.easytopass.databinding.ActivityQuizReportBinding
import com.example.easytopass.util.Constant.Companion.INTENT_ReportQUESTION_RIGHTANSWER
import com.example.easytopass.util.Constant.Companion.INTENT_ReportQUESTION_TOTALQUESTIONS
import com.example.easytopass.util.Constant.Companion.INTENT_ReportQUESTION_WRONGANSWER

class QuizReportActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizReportBinding
    private var totalQuestions: Int = 0
    private var rightAnswer: Int = 0
    private var wrongAnswer: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_quiz_report)
        getDataFromIntent()
        setDataToScreen()
        setListener()
    }
    private fun getDataFromIntent() {
        intent?.let {
            rightAnswer = it.getIntExtra(INTENT_ReportQUESTION_RIGHTANSWER, 0)
            wrongAnswer = it.getIntExtra(INTENT_ReportQUESTION_WRONGANSWER, 0)
            totalQuestions = it.getIntExtra(INTENT_ReportQUESTION_TOTALQUESTIONS, 0)
        }
    }

    private fun setDataToScreen() {


        if (rightAnswer > totalQuestions / 2) {
            setupScreen(
                "\uD83E\uDD73",
                "Well Done!",
                "You’ve succeeded in this exam",
                "$rightAnswer out of $totalQuestions"
            )
            binding.quizreportProgressbar.progressDrawable = ContextCompat.getDrawable(
                this@QuizReportActivity,
                R.drawable.progress_circular_succeeded
            )
        } else {
            setupScreen(
                "\uD83D\uDE22",
                "You can do better!",
                "You’ve failed in this exam",
                "$rightAnswer out of $totalQuestions"
            )
            binding.apply {
                quizreportQuizTextTitle.setTextColor(Color.RED)
                quizreportProgressbar.progressDrawable = ContextCompat.getDrawable(
                    this@QuizReportActivity,
                    R.drawable.progress_circular_failed
                )
                quizreportButtonBack.backgroundTintList= ColorStateList.valueOf(Color.RED)

            }
        }
        binding.quizreportProgressbar.progress =(rightAnswer * 100) / totalQuestions
    }

    private fun setupScreen(
        textIcon: String,
        quizTextTitle: String,
        quizTextResult: String,
        textScour: String
    ) {
        binding.apply {
            quizreportQuizTextTitle.text = quizTextTitle
            quizreportQuizTextResult.text = quizTextResult
            quizreportTextScour.text = textScour
            quizreportIcon.text = textIcon
        }
    }


    private fun setListener(){
        binding.quizreportButtonBack.setOnClickListener{
            finish()
        }
    }
}