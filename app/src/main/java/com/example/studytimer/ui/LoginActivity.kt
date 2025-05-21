package com.example.studytimer.ui


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studytimer.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Exemplo simples: ao abrir o login, já vai direto para MainActivity (só pra teste)
        // Remova essa parte depois e implemente o login de verdade
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
