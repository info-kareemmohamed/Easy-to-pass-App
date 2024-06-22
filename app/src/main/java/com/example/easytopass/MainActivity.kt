package com.example.easytopass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.easytopass.databinding.ActivityMainBinding
import com.example.easytopass.model.Category
import com.example.easytopass.recyclerView.RecyclerViewAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        initialRecyclerView()

        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setText("IQ"))
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setText("English"))

        addOnTabSelectedListener()
        updateRecyclerViewData(0)
    }

    private fun initialRecyclerView() {
        adapter = RecyclerViewAdapter(emptyList())
        binding.mainRecyclerView.layoutManager = GridLayoutManager(this, 3)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun addOnTabSelectedListener() {
        binding.mainTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                updateRecyclerViewData(tab.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

    private fun updateRecyclerViewData(tabPosition: Int) {
        val categories = when (tabPosition) {
            0 -> listOf(
                Category(1, "IQ Test 1", R.drawable.book),
                Category(2, "IQ Test 2", R.drawable.book_iq),
                Category(3, "IQ Test 3", R.drawable.iq)
            )

            1 -> listOf(
                Category(1, "English Test 1", R.drawable.english_book),
                Category(2, "English Test 2", R.drawable.english_book),
                Category(3, "English Test 3", R.drawable.english_book)
            )

            else -> emptyList()
        }
        adapter.setList(categories)
    }

}




