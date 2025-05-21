package com.example.studytimer.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.studytimer.R
import com.example.studytimer.ui.HistoryActivity
import com.example.studytimer.ui.TimerActivity

class MainActivity : AppCompatActivity() {
    private lateinit var userEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userEmail = intent.getStringExtra("USER_EMAIL") ?: ""

        val btnStartTimer = findViewById<Button>(R.id.btnStartTimer)
        val btnViewHistory = findViewById<Button>(R.id.btnViewHistory)

        btnStartTimer.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.putExtra("USER_EMAIL", userEmail)
            startActivity(intent)
        }

        btnViewHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            intent.putExtra("USER_EMAIL", userEmail)
            startActivity(intent)
        }
    }
}
