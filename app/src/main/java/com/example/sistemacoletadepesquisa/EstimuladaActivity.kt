package com.example.sistemacoletadepesquisa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EstimuladaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_estimulada)

        // Localiza os componentes do XML
        val rgCandidatos = findViewById<RadioGroup>(R.id.rgCandidatos)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmarEstimulada)
        val tvError = findViewById<TextView>(R.id.tvErroEstimulada)

        // Recupe os dados recebidos da tela anterior
        val pesquisaCompleta = intent.getBooleanExtra("pesquisaCompleta", false)
        val votoEspontaneo = intent.getStringExtra("votoEspontaneo") ?: ""

        btnConfirmar.setOnClickListener {
            // Descobre qual RadioButton está selecionado
            val candidatoSelecionado = rgCandidatos.checkedRadioButtonId

            // Caso tenho nenhuma opção selecionada
            if (candidatoSelecionado == -1){
                tvError.text = "Selecione um candidato."
            } else {
                tvError.text = ""

                // Localiza o RadioButton selecionado
                val radioSelecionado = findViewById<RadioButton>(candidatoSelecionado)
                // Pega o texto da opção
                val votoEstimulado = radioSelecionado.text.toString();

                if (pesquisaCompleta) {
                    val intentProblemas = Intent(this@EstimuladaActivity, ProblemasActivity::class.java)

                    // Mantém o voto espontâneo
                    intentProblemas.putExtra("votoEspontaneo", votoEspontaneo)
                    // Acrescenta o voto estimulado
                    intentProblemas.putExtra("votoEstimulado", votoEstimulado)

                    intentProblemas.putExtra("pesquisaCompleta", true)

                    startActivity(intentProblemas)

                } else {
                    Toast.makeText (
                        this,
                        "Resposta Captudada: $votoEstimulado",
                        Toast.LENGTH_SHORT
                    ).show()
                    finish()
                }
            }
        }
    }
}