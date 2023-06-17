package com.example.despesasemdia_dd.configconta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.atualizarconta.AtualizarConta
import com.example.despesasemdia_dd.deletarconta.DeletarConta

class ConfigConta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_conta)

        val btdelete = findViewById<Button>(R.id.btnDeletarConfigConta)
        val btatualizar = findViewById<Button>(R.id.btnEditarConfigConta)

        btdelete.setOnClickListener {
            val intent = Intent(this, DeletarConta::class.java)
            startActivity(intent)
        }

        btatualizar.setOnClickListener {
            val intent = Intent(this, AtualizarConta::class.java)
            startActivity(intent)
        }
    }
}