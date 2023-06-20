package com.example.despesasemdia_dd.criarconta

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.configconta.ConfigConta
import com.example.despesasemdia_dd.perfilindividual.PerfilIndividual
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.ktx.userProfileChangeRequest

class ActivityCriarConta : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    //private val db = FirebaseFirestore.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criar_conta)
        criarConta()
    }

    private fun criarConta() {
        val nome_user = findViewById<EditText>(R.id.NomeCriarConta)
        val email = findViewById<EditText>(R.id.EmailCriarConta)
        val senha = findViewById<EditText>(R.id.SenhaCriarConta)
        val rep_senha = findViewById<EditText>(R.id.RepitaSenhaCriarConta)
        val btcriar_conta = findViewById<Button>(R.id.btnCriarConta)


        btcriar_conta.setOnClickListener { view ->
            if (nome_user.text.isNotBlank() || email.text.isNotBlank() || senha.text.isNotBlank() || rep_senha.text.isNotBlank()) {
//                val usersmap = hashMapOf(
//                    "email" to email.text.toString(),
//                    "senha" to senha.text.toString(),
//                    "nome" to nome_user.text.toString()
//                )
//                db.collection("Usuários").document(email.text.toString())
//                    .set(usersmap).addOnFailureListener {
//
//                    }
                auth.createUserWithEmailAndPassword(email.text.toString(), senha.text.toString())
                    .addOnCompleteListener {
                        if (it.isSuccessful) {

                            auth.signInWithEmailAndPassword(email.text.toString(), senha.text.toString()).addOnCompleteListener {login->
                                if (login.isSuccessful) {
                                    val user = FirebaseAuth.getInstance().currentUser
                                    val profileUpdates = userProfileChangeRequest {
                                        displayName = nome_user.text.toString()
                                    }
                                    user!!.updateProfile(profileUpdates)
                                }
                            }

                            val intent = Intent(this, ConfigConta::class.java)
                            startActivity(intent)
                            finish()
                        }
                    }.addOnFailureListener { exception ->
                        val erro = when (exception) {
                            is FirebaseAuthWeakPasswordException -> "Senha deve ter pelo menos 6 digítos"
                            is FirebaseAuthInvalidCredentialsException -> "Email inválido"
                            is FirebaseAuthUserCollisionException -> "Email já cadastrado"
                            is FirebaseNetworkException -> "Sem conexão com a internet"
                            else -> "Erro ao realizar cadastro"
                        }
                        val snackbar = Snackbar.make(view, erro, Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.RED)
                        snackbar.show()
                    }
            }
        }
    }
}