package com.example.sistemacoletadepesquisa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etSenha = findViewById<EditText>(R.id.etSenha)

        val btnAcessar = findViewById<Button>(R.id.btnAcessar)

        val tvErro = findViewById<TextView>(R.id.tvErro)

        btnAcessar.setOnClickListener {

            val usuario = etUsuario.text.toString().trim()
            val senha = etSenha.text.toString()

            when {

                usuario == "admin" && senha == "admin" -> {

                    val intent = Intent(
                        this,
                        AdminActivity::class.java
                    )

                    startActivity(intent)
                }

                usuario == "entrevistador" &&
                        senha == "entrevistador" -> {

                    val intent = Intent(
                        this,
                        EntrevistadorActivity::class.java
                    )

                    startActivity(intent)
                }

                else -> {

                    tvErro.text = "Usuário ou senha inválidos."

                }
            }
        }
    }
}