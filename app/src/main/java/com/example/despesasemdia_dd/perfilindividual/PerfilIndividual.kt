package com.example.despesasemdia_dd.perfilindividual

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.paginainicial.PaginaInicial
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilIndividual : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_individual)
        voltarParaPrincipal()

    }

    @SuppressLint("SetTextI18n")
    private fun somaDespesa(){
        val collectionRef = db.collection("Despesas")

        collectionRef.get()
            .addOnSuccessListener { querySnapshot ->
                var soma = 0

                for (document in querySnapshot) {
                    val valor = document.getLong("Valor")?.toInt() ?: 0
                    soma += valor
                }

                val txtdespesa = findViewById<TextView>(R.id.despesaTotalPerfilIndividual)
                txtdespesa.text = "Despesa Total: $soma R$"
            }

    }


    private fun voltarParaPrincipal(){
        val btvoltar = findViewById<ImageButton>(R.id.btnVoltarPerfilIndividual)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, PaginaInicial::class.java)
            startActivity(intent)
            finish()
        }
    }

        override fun onStart() {
            super.onStart()
            val txtnome = findViewById<TextView>(R.id.NomeUserPerfIndividual)
            val username = user?.displayName
            txtnome.text = username
            somaDespesa()
    }

}