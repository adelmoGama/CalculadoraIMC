package com.example.projetoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)
        tvResult.text = result.toString()

        var classificacao = ""

        if(result < 18.5f) {
            classificacao = "ABAIXO DO PESO"
        }else if(result in 18.5f..24.9f) {
            classificacao = "NORMAL"
        }else if(result in 25f..29.9f) {
            classificacao = "SOBREPESO I"
        }else if(result in 30f..39.9f) {
            classificacao = "OBESIDADE II"
        }else if(result >= 40f){
            classificacao = "OBESIDADE GRAVE III"
        }

        tvClassificacao.text = getString(R.string.menssage_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}