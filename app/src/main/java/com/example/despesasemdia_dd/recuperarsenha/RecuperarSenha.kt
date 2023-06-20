package com.example.despesasemdia_dd.recuperarsenha

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth

class RecuperarSenha : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recuperar_senha)

        recuperarSenha()
    }
    private fun recuperarSenha(){
        val recuperarSenha = findViewById<EditText>(R.id.EmailRecuperarSenha)
        val btrecuperarsenha = findViewById<Button>(R.id.btnEnviarRecuperarSenha)

        btrecuperarsenha.setOnClickListener { view ->
            if (recuperarSenha.text.isNotEmpty()) {
                auth.sendPasswordResetEmail(recuperarSenha.text.toString()).addOnSuccessListener {
                    val snackbar = Snackbar.make(view, "Email enviado", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.GREEN)
                    snackbar.show()
                }.addOnFailureListener { exception ->
                    val erro = when (exception) {
                        is FirebaseNetworkException -> "Sem conexão com a internet"
                        else -> "Email invalido ou não cadastrado"
                    }
                    val snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.BLACK)
                    snackbar.show()
                }
            }
        }
    }
}