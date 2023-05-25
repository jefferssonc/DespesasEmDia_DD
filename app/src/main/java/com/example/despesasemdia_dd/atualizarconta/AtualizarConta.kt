package com.example.despesasemdia_dd.atualizarconta

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.ktx.Firebase

class AtualizarConta : AppCompatActivity() {

    private val user = Firebase.auth.currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_conta)

        val nome = findViewById<EditText>(R.id.NomeCriarConta).text.toString()
        val email = findViewById<EditText>(R.id.EmailCriarConta).text.toString()
        val senha = findViewById<EditText>(R.id.SenhaCriarConta).text.toString()
        val btatualizar = findViewById<Button>(R.id.btnCriarConta)

        btatualizar.setOnClickListener { view ->
            if (nome.isNotBlank() || email.isNotBlank() || senha.isNotBlank()) {
                atualizaEmail(email)
                atualizaSenha(senha)
                atualizaNome(nome)
            }
        }
    }

    private fun mensagem(erro: String) {
        val snackbar =
            Snackbar.make(findViewById(android.R.id.content), erro, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }

    private fun atualizaEmail(email: String) {

        user!!.updateEmail(email).addOnFailureListener { exception ->
            val erro = when (exception) {
                is FirebaseAuthInvalidCredentialsException -> "Email inválido"
                is FirebaseNetworkException -> "Sem conexão com a internet"
                else -> "Erro ao atualizar email"
            }
            mensagem(erro)
        }
    }

    private fun atualizaSenha(senha: String) {

        user!!.updatePassword(senha).addOnFailureListener { exception ->
            val erro = when (exception) {
                is FirebaseAuthWeakPasswordException -> "Senha deve ter pelo menos 6 digítos"
                is FirebaseNetworkException -> "Sem conexão com a internet"
                else -> "Erro ao atualizar senha"
            }
            mensagem(erro)
        }
    }

    private fun atualizaNome(nome: String) {

        val profileUpdates = userProfileChangeRequest {
            displayName = nome
        }
        user!!.updateProfile(profileUpdates).addOnFailureListener { exception ->
            val erro = when (exception) {
                is FirebaseNetworkException -> "Sem conexão com a internet"
                else -> "Erro ao atualizar nome"
            }
            mensagem(erro)
        }
    }
}