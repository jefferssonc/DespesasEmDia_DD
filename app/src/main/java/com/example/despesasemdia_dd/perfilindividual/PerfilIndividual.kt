package com.example.despesasemdia_dd.perfilindividual

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterPerfil
import com.example.despesasemdia_dd.model.DespesaIndividual
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilIndividual : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_individual)

        val recyclerView_PerfilIndividual = findViewById<RecyclerView>(R.id.recyclerViewPerfilIndividual)
        recyclerView_PerfilIndividual.layoutManager = LinearLayoutManager(this)
        recyclerView_PerfilIndividual.setHasFixedSize(true)

        //Configurar o adapter
        val itens_Perfil:MutableList<DespesaIndividual> = mutableListOf()
        val adapter_Individual = AdapterPerfil(this,itens_Perfil )
        recyclerView_PerfilIndividual.adapter = adapter_Individual
        val despesa1 = DespesaIndividual("Casa", 10.25)
        val despesa2 = DespesaIndividual("Outros", 24.24)
        val despesa3 = DespesaIndividual("Outros", 11.11)
        val despesa4 = DespesaIndividual("Outros", 24.11)
        val despesa5 = DespesaIndividual("Outros", 11.24)
        itens_Perfil.add(despesa1)
        itens_Perfil.add(despesa2)
        itens_Perfil.add(despesa3)
        itens_Perfil.add(despesa4)
        itens_Perfil.add(despesa5)

    }

    @SuppressLint("SetTextI18n")
    private fun somaDespesa(){
        val collectionRef = db.collection("Despesas")

        collectionRef.whereEqualTo("Conta", user?.displayName).get()
            .addOnSuccessListener { querySnapshot ->
                var soma = 0

                for (document in querySnapshot) {
                    // Obtém o valor do campo desejado (substitua "campo" pelo nome do campo)
                    val valor = document.getLong("Valor")?.toInt() ?: 0

                    // Soma os valores
                    soma += valor
                }

                val txtdespesa = findViewById<TextView>(R.id.despesaTotalPerfilIndividual)
                txtdespesa.text = "Despesa Total: $soma R$"
            }

    }


//    private fun voltarParaPrincipal(voltar: String){
//        val btvoltar = findViewById<Button>(R.id.imageView5)
//
//        btvoltar.setOnClickListener{view ->
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }

        override fun onStart() {
            super.onStart()
            val txtnome = findViewById<TextView>(R.id.NomeUserPerfIndividual)
            val username = user?.displayName
            txtnome.text = username
            somaDespesa()
    }

}