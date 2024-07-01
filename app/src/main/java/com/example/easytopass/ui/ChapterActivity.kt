package com.example.easytopass.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.easytopass.R
import com.example.easytopass.adapter.ChapterRecyclerViewAdapter
import com.example.easytopass.databinding.ActivityChapterBinding
import com.example.easytopass.model.Chapter
import com.example.easytopass.model.Question
import com.example.easytopass.util.Constant.Companion.INTENT_CHAPTER_LIST
import com.example.easytopass.util.Constant.Companion.INTENT_QUESTION_LIST

class ChapterActivity : AppCompatActivity(),ChapterRecyclerViewAdapter.OnChapterCardClickListener {
    private lateinit var binding: ActivityChapterBinding
    private lateinit var adapter: ChapterRecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chapter)

        val chapters: ArrayList<Chapter>? = intent.getParcelableArrayListExtra(INTENT_CHAPTER_LIST)

        adapter = ChapterRecyclerViewAdapter(chapters!!.toList(),this)
        binding.itemsRecyclerView.adapter = adapter
        binding.itemsRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.itemsRecyclerView.setHasFixedSize(true)


    }

    override fun onClick(questions: List<Question>) {
        val intent: Intent = Intent(this, QuizActivity::class.java).apply {
            putParcelableArrayListExtra(INTENT_QUESTION_LIST, ArrayList(questions))
        }
        startActivity(intent)


    }
}