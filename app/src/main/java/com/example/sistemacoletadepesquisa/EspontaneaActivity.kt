package com.example.sistemacoletadepesquisa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class EspontaneaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_espontanea)

        // Localiza os camponentes criados no XMl
        val etCandidato = findViewById<EditText>(R.id.etCandidatoEspontaneo);
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmarEspontanea);
        val tvErro = findViewById<TextView>(R.id.tvErroEspontanea);

        // Recupera a informação enviada pela tela anterior
        val pesquisaCompleta = intent.getBooleanExtra("pesquisaCompleta", false)

        // Execurando quanto o usuário clicar em 'Confirmar'
        btnConfirmar.setOnClickListener {

            //Capturando a resposta digitada
            val candidato = etCandidato.text.toString().trim()

            // Validando resposta
            if (candidato.isBlank()) {
                tvErro.text = "Informe uma resposta válida."
            } else {
                tvErro.text = ""

                // Se estiver realizando a pesquisa completa, segue para a pesquisa estimulada
                if (pesquisaCompleta) {
                    val intentEstimulada  = Intent(this@EspontaneaActivity, EstimuladaActivity::class.java )


                    //Enviar o voto espontâneo para a próxima tela
                    intentEstimulada.putExtra(
                        "votoEspontaneo",
                        candidato
                    )

                    intentEstimulada.putExtra(
                        "pesquisaCompleta",
                        true
                    )

                    startActivity(intentEstimulada)
                } else {

                    Toast.makeText(
                        this,
                        "Resposta capturada.",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()

                }
            }
        }
    }
}