package com.example.despesasemdia_dd.despesasitem

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.despesaunica.DespesaUnica

class DespesasItem : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.despesas_item)

        val btadicionar = findViewById<ImageButton>(R.id.btnDespesas)
        btadicionar.setOnClickListener { view ->
            val intent = Intent(this, DespesaUnica::class.java)
            startActivity(intent)

        }


    }
}