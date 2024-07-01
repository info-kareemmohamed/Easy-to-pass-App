package com.example.easytopass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.easytopass.model.Category
import com.example.easytopass.adapter.MainRecyclerViewAdapter
import com.example.easytopass.databinding.ActivityMainBinding
import com.example.easytopass.model.Book
import com.example.easytopass.model.Chapter
import com.example.easytopass.model.Question
import com.example.easytopass.ui.ChapterActivity
import com.example.easytopass.util.Constant.Companion.INTENT_CHAPTER_LIST
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), MainRecyclerViewAdapter.OnMainCardClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Thread.sleep(2000)
        installSplashScreen()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        initialRecyclerView()
        val categories = listOf(
            Category(
                1, "IQ", listOf(
                    Book(
                        1L, "501 Challenging IQ", listOf(
                            Chapter(
                                1L, "Chapter 1", "501 Challenging IQ", 10, generateQuestions(10)
                            ), Chapter(
                                2L, "Chapter 2", "501 Challenging IQ", 10, generateQuestions(10)
                            ), Chapter(
                                3L, "Chapter 3", "501 Challenging IQ", 10, generateQuestions(10)
                            ), Chapter(
                                4L, "Chapter 4", "501 Challenging IQ", 10, generateQuestions(10)
                            )
                        ), "iq_book_image.jpg"
                    ),
                    Book(
                        2L, "Advanced IQ", listOf(
                            Chapter(
                                2L, "Chapter 2", "Advanced IQ", 8, generateQuestions(8)
                            )
                        ), "advanced_iq_image.jpg"
                    ),
                    Book(
                        3L, "IQ Test", listOf(
                            Chapter(
                                3L, "Chapter 3", "IQ Test", 12, generateQuestions(12)
                            )
                        ), "iq_test_image.jpg"
                    )
                )
            ),
            Category(
                2, "English", listOf(
                    Book(
                        4L, "English Test 1", listOf(
                            Chapter(
                                4L, "Chapter 1", "English Test 1", 15, generateQuestions(15)
                            )
                        ), "english_test_1_image.jpg"
                    ),
                    Book(
                        5L, "English Test 2", listOf(
                            Chapter(
                                5L, "Chapter 2", "English Test 2", 10, generateQuestions(10)
                            )
                        ), "english_test_2_image.jpg"
                    ),
                    Book(
                        6L, "English Test 3", listOf(
                            Chapter(
                                6L, "Chapter 3", "English Test 3", 20, generateQuestions(20)
                            )
                        ), "english_test_3_image.jpg"
                    )
                )
            )
        )


        categories.forEach {
            binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setText(it.name))
        }

        addOnTabSelectedListener(categories)
        updateRecyclerViewData(categories[0].id, categories)
    }

    private fun initialRecyclerView() {
        adapter = MainRecyclerViewAdapter(emptyList(), this)
        binding.mainRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun addOnTabSelectedListener(categories: List<Category>) {
        binding.mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                updateRecyclerViewData(categories[tab.position].id, categories)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }

    private fun updateRecyclerViewData(categoryId: Int, categories: List<Category>) {
        val books = when (categoryId) {
            1 -> categories[0].books

            2 -> categories[1].books

            else -> emptyList()
        }
        adapter.setList(books)
    }

    override fun onClick(chapter: List<Chapter>) {
        val intent: Intent = Intent(this, ChapterActivity::class.java).apply {
            putParcelableArrayListExtra(INTENT_CHAPTER_LIST, ArrayList(chapter))
        }
        startActivity(intent)
    }


    private fun generateQuestions(count: Int): List<Question> {
        val questions = mutableListOf<Question>()
        for (i in 1..count) {
            questions.add(
                Question(
                    i.toLong(),
                    "The top set of six numbers has a relationship to the set of six\n" +
                            "numbers below. The two sets of six boxes on the left have\n" +
                            "the same relationship as the two sets of six boxes on the\n" +
                            "right. Which set of numbers should therefore replace the\n" +
                            "question marks? $i",
                    listOf("shelter palace _______", "Vernon does not vacuum and does not do his\n" +
                            "task on Tuesday.", "Option C $i", "Option D"),
                    "",
                    "shelter palace _______",
                    0
                )
            )
        }
        return questions
    }
}




