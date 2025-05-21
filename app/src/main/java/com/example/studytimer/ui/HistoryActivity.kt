package com.example.studytimer.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.studytimer.R
import com.example.studytimer.model.Session

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val userEmail = intent.getStringExtra("USER_EMAIL") ?: ""

        val recyclerView = findViewById<RecyclerView>(R.id.rvSessions)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Exemplo hardcoded de sessões
        val exampleSessions = listOf(
            Session("Sessão de Matemática", 60, "2025-05-20"),
            Session("Sessão de Português", 45, "2025-05-19"),
            Session("Sessão de Física", 30, "2025-05-18")
        )

        val adapter = SessionAdapter(exampleSessions)
        recyclerView.adapter = adapter

        val btnBack = findViewById<Button>(R.id.btnBackToMenu)
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("USER_EMAIL", userEmail)
            startActivity(intent)
            finish()
        }
    }
}
