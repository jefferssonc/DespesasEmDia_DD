package com.example.despesasemdia_dd.adicionardespesa

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.paginainicial.PaginaInicial
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.FirebaseFirestore

class AdicionarDespesa : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_despesa)

        voltarParaInicial()

        val valor = findViewById<EditText>(R.id.editTextText2)
        val categoria = findViewById<EditText>(R.id.editTextText3)
        val btadicionar = findViewById<ImageButton>(R.id.imageButton)

        btadicionar.setOnClickListener {view->
            val texto = valor.text.toString()
            val usersmap = hashMapOf(
                "Valor" to texto.toDoubleOrNull(),
                "Nome" to categoria.text.toString(),
            )
            db.collection("Despesas").document(categoria.text.toString())
                .set(usersmap).addOnCompleteListener {
                    val snackbar = Snackbar.make(view, "Despesa adicionada", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.GREEN)
                    snackbar.show()

                }
        }
    }
    private fun voltarParaInicial(){
        val btvoltar = findViewById<ImageButton>(R.id.btnVoltarPerfilIndividual)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, PaginaInicial::class.java)
            startActivity(intent)
            finish()
        }
    }
}