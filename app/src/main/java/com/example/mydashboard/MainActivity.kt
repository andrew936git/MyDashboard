package com.example.mydashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydashboard.databinding.ActivityMainBinding
import com.example.mydashboard.fragments.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment()).commit()
    }
}