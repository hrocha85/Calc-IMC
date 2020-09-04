package com.example.calculadoraimckotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        // Obter o dado passado pela intent
        val resultado = intent.getDoubleExtra("INTENT_RESULTADO", 0.0)


        txvResultadoValor.text = Math.round(resultado) .toString().replace(".", ",")

        // Botão sair da aplicação
        btnResultadoSair.setOnClickListener {
            //Criando um alerta
            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Você realmente deseja sair?")
                .setPositiveButton("Sim"){_,_ ->
                    //Executando o clique do botão Sim
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)
                    //Retirando todas as telas do empilhamento
                    finishAffinity()
                }
                .setNeutralButton("Cancelar"){_,_ ->}
                .setCancelable(false)
                .create()
                .show()
        }
    }
}
