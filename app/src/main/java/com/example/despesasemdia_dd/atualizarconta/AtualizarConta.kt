package com.example.despesasemdia_dd.atualizarconta

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.userProfileChangeRequest

class AtualizarConta : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_atualizar_conta)

        val nome = findViewById<EditText>(R.id.NomeCriarConta)
        val email = findViewById<EditText>(R.id.EmailCriarConta)
        val senha = findViewById<EditText>(R.id.SenhaCriarConta)
        val btteste = findViewById<Button>(R.id.btnCriarConta)

        btteste.setOnClickListener {
            if (email.text.isNotEmpty()) {
                atualizaEmail(email.text.toString(), senha.text.toString(), nome.text.toString())



            }
        }
    }
    private fun atualizaEmail(email: String, senha: String, nome: String) {

        user!!.updateEmail(email).addOnCompleteListener {

            user.updatePassword(senha).addOnCompleteListener {

                val profileUpdates = userProfileChangeRequest {
                displayName = nome
        }
        user.updateProfile(profileUpdates).addOnFailureListener { exception ->
            val erro = when (exception) {
                is FirebaseNetworkException -> "Sem conexão com a internet"
                else -> "Erro ao atualizar nome"
            }
            mensagem(erro)
        }

            }.addOnFailureListener { exception ->
            val erro = when (exception) {
                is FirebaseAuthWeakPasswordException -> "Senha deve ter pelo menos 6 digítos"
                is FirebaseNetworkException -> "Sem conexão com a internet"
                else -> "Erro ao atualizar senha"
            }
            mensagem(erro)
        }

        }.addOnFailureListener { exception ->
            val erro = when (exception) {
                is FirebaseAuthUserCollisionException -> "Email já cadastrado"
                is FirebaseAuthInvalidCredentialsException -> "Email inválido"
                is FirebaseNetworkException -> "Sem conexão com a internet"
                else -> "Erro ao atualizar email"
            }
            mensagem(erro)
        }
    }

//    private fun atualizaSenha(senha: String) {
//
//        user!!.updatePassword(senha).addOnFailureListener { exception ->
//            val erro = when (exception) {
//                is FirebaseAuthWeakPasswordException -> "Senha deve ter pelo menos 6 digítos"
//                is FirebaseNetworkException -> "Sem conexão com a internet"
//                else -> "Erro ao atualizar senha"
//            }
//            mensagem(erro)
//        }
//    }
//
//    private fun atualizaNome(nome: String) {
//
//        val profileUpdates = userProfileChangeRequest {
//            displayName = nome
//        }
//        user!!.updateProfile(profileUpdates).addOnFailureListener { exception ->
//            val erro = when (exception) {
//                is FirebaseNetworkException -> "Sem conexão com a internet"
//                else -> "Erro ao atualizar nome"
//            }
//            mensagem(erro)
//        }
//    }

    private fun mensagem(erro: String) {
        val snackbar =
            Snackbar.make(findViewById(android.R.id.content), erro, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.RED)
        snackbar.show()
    }

}