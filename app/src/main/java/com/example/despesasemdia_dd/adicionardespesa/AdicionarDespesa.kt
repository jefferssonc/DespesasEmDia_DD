package com.example.despesasemdia_dd.adicionardespesa

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.perfilindividual.PerfilIndividual
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AdicionarDespesa : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_despesa)

        voltarParaInicial()

        val valor = findViewById<EditText>(R.id.inputValorDespesa)
        val categoria = findViewById<EditText>(R.id.inputCategoriaDespesa)
        val btadicionar = findViewById<ImageButton>(R.id.btnAdicionarDespesaAdicionar)

        btadicionar.setOnClickListener { view ->
            val texto = valor.text.toString()

                    val usersmap = hashMapOf(
                        "Valor" to texto.toDoubleOrNull(),
                        "Nome" to categoria.text.toString(),
                        "Conta" to user?.displayName
                    )
                    db.collection("Despesas").document(categoria.text.toString() + user?.displayName)
                        .set(usersmap).addOnCompleteListener {
                            val snackbar =
                                Snackbar.make(view, "Despesa adicionada", Snackbar.LENGTH_SHORT)
                            snackbar.setBackgroundTint(Color.GREEN)
                            snackbar.show()
                        }

        }
    }
    private fun voltarParaInicial(){
        val btvoltar = findViewById<ImageButton>(R.id.imageButton2)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, PerfilIndividual::class.java)
            startActivity(intent)
        }
    }
}