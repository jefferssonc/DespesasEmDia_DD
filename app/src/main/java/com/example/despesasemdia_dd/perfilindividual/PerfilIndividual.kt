package com.example.despesasemdia_dd.perfilindividual

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterPagInicial
import com.example.despesasemdia_dd.adapter.AdapterPerfilIndividuall
import com.example.despesasemdia_dd.model.Despesas
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilIndividual : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_individual)

        val recyclerView_PerfilInidividual = findViewById<RecyclerView>(R.id.recyclerViewPerfilIndividual)
        recyclerView_PerfilInidividual.layoutManager = LinearLayoutManager(this)
        recyclerView_PerfilInidividual.setHasFixedSize(true)
        //configurando adapter
        val listaPerfilIndividual :MutableList<Despesas> = mutableListOf()
        val adapterPerfilIndividual = AdapterPerfilIndividuall(this,listaPerfilIndividual)
        recyclerView_PerfilInidividual.adapter = adapterPerfilIndividual

        //criando items da Despesa pag inicial

        val despesa1 = Despesas(
            "Comida",
            null,
            "300,20",
            "23/04/12"
        )
        listaPerfilIndividual.add(despesa1)
        val despesa2 = Despesas(
            "Comida",
            null,
            "300,20",
            "23/04/12"
        )
        listaPerfilIndividual.add(despesa2)
        val despesa3 = Despesas(
            "Comida",
            null,
            "300,20",
            "23/04/12"
        )
        listaPerfilIndividual.add(despesa3)
    }

    @SuppressLint("SetTextI18n")
    private fun somaDespesa(){
        val collectionRef = db.collection("Despesas")

        collectionRef.get()
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