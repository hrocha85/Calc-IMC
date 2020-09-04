package com.example.calculadoraimckotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalcular.setOnClickListener {

            val peso = edtMainPeso.text.toString().trim()
            val altura = edtMainAltura.text.toString().trim()

            // Verificando se os campos estão vazios
            if (peso.isEmpty()) {
                edtMainPeso.error = "Campo obrigatório"
                edtMainPeso.requestFocus()
            }
            else if (altura.isEmpty()) {
                edtMainAltura.error = "Campo obrigatório"
                edtMainAltura.requestFocus()
            }

            else {  val resultado = (peso.toDouble()/(altura.toDouble() * altura.toDouble())*10000)



                val mIntent = Intent(this, ResultadoActivity::class.java)

                //Passando informações através da Intent
                mIntent.putExtra("INTENT_RESULTADO", resultado)

                // Iniciar activity
                startActivity(mIntent)

                // Encerrar a Activity
                finish()

            }


        }



    }
}