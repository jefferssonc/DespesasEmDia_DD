package com.example.despesasemdia_dd.perfilindividual

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterPerfil
import com.example.despesasemdia_dd.adicionardespesa.AdicionarDespesa
import com.example.despesasemdia_dd.configconta.ConfigConta
import com.example.despesasemdia_dd.despesas.Despesas
import com.example.despesasemdia_dd.model.DespesaIndividual
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilIndividual : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_individual)

        //voltarParaPrincipal()
        irParaAdd()
        irParaDespesa()
        irParaConfig()
        voltarParaPrincipal()


        val recyclerView_PerfilIndividual = findViewById<RecyclerView>(R.id.recyclerViewPerfilIndividual)
        recyclerView_PerfilIndividual.layoutManager = LinearLayoutManager(this)
        recyclerView_PerfilIndividual.setHasFixedSize(true)

        //Configurar o adapter
        val itens_Perfil:MutableList<DespesaIndividual> = mutableListOf()
        val adapter_Individual = AdapterPerfil(this,itens_Perfil )
        //recyclerView_PerfilIndividual.adapter = adapter_Individual




        val collectionRef = db.collection("Despesas")

        collectionRef.whereEqualTo("Conta", user?.displayName).get()
            .addOnSuccessListener { querySnapshot ->

                for (document in querySnapshot) {
                    val valor = document.getLong("Valor")
                    val nome = document.getString("Nome")
                    recyclerView_PerfilIndividual.adapter = adapter_Individual
                    val despesa = DespesaIndividual(nome.toString(),
                        valor.toString())

                    itens_Perfil.add(despesa)
                }
            }
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


    private fun voltarParaPrincipal(){
        val btvoltar = findViewById<ImageButton>(R.id.btnHomePerfil)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, PerfilIndividual::class.java)
            startActivity(intent)
        }
    }

    private fun irParaAdd() {
        val btvoltar = findViewById<ImageButton>(R.id.btnAdicionarDespesaPerfil)

        btvoltar.setOnClickListener { view ->
            val intent = Intent(this, AdicionarDespesa::class.java)
            startActivity(intent)
        }
    }

    private fun irParaDespesa(){
        val btvoltar = findViewById<ImageButton>(R.id.btnRelatorioDespesaPerfil)

        btvoltar.setOnClickListener { view ->
            val intent = Intent(this, Despesas::class.java)
            startActivity(intent)
        }
    }

    private fun irParaConfig(){
        val btvoltar = findViewById<ImageButton>(R.id.btnCrudUser)

        btvoltar.setOnClickListener { view ->
            val intent = Intent(this, ConfigConta::class.java)
            startActivity(intent)
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