package com.example.sistemacoletadepesquisa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EntrevistadorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_entrevistador)

        val btnPesquisaCompleta =
            findViewById<Button>(R.id.btnPesquisaCompleta)

        val btnEspontanea =
            findViewById<Button>(R.id.btnEspontanea)

        val btnEstimulada =
            findViewById<Button>(R.id.btnEstimulada)

        val btnProblemas =
            findViewById<Button>(R.id.btnProblemas)

        btnPesquisaCompleta.setOnClickListener {

            val intent = Intent(
                this,
                EspontaneaActivity::class.java
            )

            startActivity(intent)
        }

        btnEspontanea.setOnClickListener {

            val intent = Intent(
                this,
                EspontaneaActivity::class.java
            )

            startActivity(intent)
        }

        btnEstimulada.setOnClickListener {

            val intent = Intent(
                this,
                EstimuladaActivity::class.java
            )

            startActivity(intent)
        }

        btnProblemas.setOnClickListener {

            val intent = Intent(
                this,
                ProblemasActivity::class.java
            )

            startActivity(intent)
        }
    }
}