package com.example.easytopass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.easytopass.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setText("IQ"))
        binding.mainTabLayout.addTab(binding.mainTabLayout.newTab().setText("English"))
    }
}