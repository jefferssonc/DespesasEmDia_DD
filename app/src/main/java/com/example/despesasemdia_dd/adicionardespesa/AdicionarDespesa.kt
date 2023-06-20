package com.example.despesasemdia_dd.adicionardespesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import com.example.despesasemdia_dd.R
import com.google.firebase.firestore.FirebaseFirestore

class AdicionarDespesa : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_despesa)

        val valor = findViewById<EditText>(R.id.editTextText2)
        val categoria = findViewById<EditText>(R.id.editTextText3)
        val btadicionar = findViewById<ImageButton>(R.id.imageButton)

        btadicionar.setOnClickListener {
            val texto = valor.text.toString()
            val usersmap = hashMapOf(
                "email" to texto.toIntOrNull(),
                "senha" to categoria.text.toString(),
            )
            db.collection("Usuários").document(categoria.text.toString())
                .set(usersmap)
        }
    }
}