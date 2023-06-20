package com.example.despesasemdia_dd.paginainicial

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesa
import com.example.despesasemdia_dd.model.Despesa
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PaginaInicial : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial)

        val recyclerView_despesas = findViewById<RecyclerView>(R.id.recyclerView_despesas)
        recyclerView_despesas.layoutManager= LinearLayoutManager(this)
        recyclerView_despesas.setHasFixedSize(true)
        //Configuração do adapter
        val listaDespesas: MutableList<Despesa> = mutableListOf()
        val adapterDespesa = AdapterDespesa(this,listaDespesas)
        recyclerView_despesas.adapter = adapterDespesa
        //criando items

        db.collection("Despesas").document("Residencia").addSnapshotListener { valor, error ->
            if(valor != null){
                val preco = valor.getLong("Valor")
                recyclerView_despesas.adapter = adapterDespesa
                val despesa1 = Despesa(
                    R.drawable.home_house_icon,
                    nome = "Residencia",
                    preco = preco.toString()
                )
                listaDespesas.add(despesa1)
            }
        }

//        val despesa1 = Despesa(
//            R.drawable.home_house_icon,
//            nome = "Residencia",
//            preco = preco
//        )
//        listaDespesas.add(despesa1)
    }

//    private fun lerDespesa(nome:String){
//        db.collection("Despesas").document(nome).addSnapshotListener { valor, error ->
//            if(valor != null){
//                val preco = valor.getLong("Valor")
//
//            }
//        }
//    }

    override fun onStart() {
        super.onStart()
        val txtnome = findViewById<TextView>(R.id.textView)
        val username = user?.displayName
        txtnome.text = username
    }
}