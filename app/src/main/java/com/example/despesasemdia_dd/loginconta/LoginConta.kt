package com.example.despesasemdia_dd.loginconta

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.criarconta.CriarConta
import com.example.despesasemdia_dd.paginainicial.PaginaInicial
import com.example.despesasemdia_dd.recuperarsenha.RecuperarSenha
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class LoginConta : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_conta)

        login()
        enviarParaCadastro()
        enviarParaRecsenha()


    }
    private fun enviarParaCadastro(){
        val btcadastro = findViewById<Button>(R.id.btnCadastrarLoginConta)

        btcadastro.setOnClickListener {
            val intent = Intent(this, CriarConta::class.java)
            startActivity(intent)
        }
    }
    private fun login(){
        val email = findViewById<EditText>(R.id.EmailLoginConta)
        val senha = findViewById<EditText>(R.id.SenhaLoginConta)
        val btlogin = findViewById<Button>(R.id.btnEntrarLoginConta)

        btlogin.setOnClickListener {view ->
            if (email.text.isNotBlank() || senha.text.isNotBlank()){
                auth.signInWithEmailAndPassword(email.text.toString(), senha.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful) {
                        mudarParaPrincipal()
                    }
                }.addOnFailureListener {exception ->
                    val erro = when(exception){
                        is FirebaseNetworkException -> "Sem conexão com a internet"
                        is FirebaseAuthInvalidCredentialsException -> "Email ou senha inválido"
                        else -> "Erro ao realizar login"

                    }
                    val snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()

                }
            }
        }
    }
    private fun mudarParaPrincipal(){
        val intent = Intent(this, PaginaInicial::class.java)
        startActivity(intent)
        finish()
    }
    private fun enviarParaRecsenha(){
        val btcadastro = findViewById<Button>(R.id.btnRecuperarSenhaLoginConta)

        btcadastro.setOnClickListener {
            val intent = Intent(this, RecuperarSenha::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()

        val usuarioLogado = FirebaseAuth.getInstance().currentUser

        if (usuarioLogado != null){
            mudarParaPrincipal()
        }
    }
}