package com.example.despesasemdia_dd.deletarconta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.loginconta.LoginConta
import com.google.firebase.auth.FirebaseAuth

class DeletarConta : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deletar_conta)

        val btdeletar = findViewById<Button>(R.id.btnDeletarDeletarConta)

        btdeletar.setOnClickListener {


            user.delete().addOnCompleteListener { deletar ->
                    if (deletar.isSuccessful) {
                       val intent = Intent(this, LoginConta::class.java)
                       startActivity(intent)

                    }
                }
        }
    }
}



