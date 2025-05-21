package com.example.studytimer.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.studytimer.R

class TimerActivity : AppCompatActivity() {

    private lateinit var tvTimer: TextView
    private lateinit var btnStart: Button
    private lateinit var btnStop: Button
    private lateinit var btnBack: Button
    private lateinit var etSessionTitle: EditText

    private var secondsElapsed = 0
    private var running = false
    private val handler = Handler(Looper.getMainLooper())

    private val runnable = object : Runnable {
        override fun run() {
            val minutes = secondsElapsed / 60
            val seconds = secondsElapsed % 60
            tvTimer.text = String.format("%02d:%02d", minutes, seconds)
            if (running) {
                secondsElapsed++
                handler.postDelayed(this, 1000)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        tvTimer = findViewById(R.id.tvTimer)
        btnStart = findViewById(R.id.btnStart)
        btnStop = findViewById(R.id.btnStop)
        btnBack = findViewById(R.id.btnBack)
        etSessionTitle = findViewById(R.id.etSessionTitle)

        btnStart.setOnClickListener {
            if (!running) {
                running = true
                handler.post(runnable)
            }
        }

        btnStop.setOnClickListener {
            running = false
            // Aqui você pode salvar a sessão, se quiser
        }

        btnBack.setOnClickListener {
            finish() // Fecha esta Activity e volta para a anterior (MainActivity)
        }
    }
}
