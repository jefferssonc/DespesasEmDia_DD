package com.example.despesasemdia_dd.configconta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.atualizarconta.AtualizarConta
import com.example.despesasemdia_dd.deletarconta.DeletarConta
import com.example.despesasemdia_dd.loginconta.LoginConta
import com.google.firebase.auth.FirebaseAuth

class ConfigConta : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config_conta)



        val btdelete = findViewById<Button>(R.id.btnDeletarConfigConta)
        val btatualizar = findViewById<Button>(R.id.btnEditarConfigConta)
        val btsair = findViewById<Button>(R.id.Sair)

        btdelete.setOnClickListener {
            val intent = Intent(this, DeletarConta::class.java)
            startActivity(intent)
        }

        btatualizar.setOnClickListener {
            val intent = Intent(this, AtualizarConta::class.java)
            startActivity(intent)
        }
        btsair.setOnClickListener {
            user.signOut()
            val intent = Intent(this, LoginConta::class.java)
            startActivity(intent)
        }
    }
}