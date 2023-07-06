package com.example.despesasemdia_dd.deletarconta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.configconta.ConfigConta
import com.example.despesasemdia_dd.loginconta.LoginConta
import com.google.firebase.auth.FirebaseAuth

class DeletarConta : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar_conta)

        val btdeletar = findViewById<Button>(R.id.btnDeletarDeletarConta)
        val btvoltar = findViewById<Button>(R.id.btnVoltarDeletarConta)

        btdeletar.setOnClickListener {


            user.delete().addOnCompleteListener { deletar ->
                    if (deletar.isSuccessful) {
                       val intent = Intent(this, LoginConta::class.java)
                       startActivity(intent)

                    }
                }
        }
        btvoltar.setOnClickListener {

            val intent = Intent(this, ConfigConta::class.java)
            startActivity(intent)

        }
    }
}



