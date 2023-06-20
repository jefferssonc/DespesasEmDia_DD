package com.example.despesasemdia_dd.paginainicial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesa
import com.example.despesasemdia_dd.model.Despesa
import com.google.firebase.auth.FirebaseAuth

class PaginaInicial : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser

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
        val despesa1 = Despesa(
            R.drawable.home_house_icon,
            nome = "Residencia",
            preco = ""
        )
        listaDespesas.add(despesa1)
    }

    override fun onStart() {
        super.onStart()
        val txtnome = findViewById<TextView>(R.id.NomeUserPerfIndividual)
        val username = user?.displayName
        txtnome.text = username
    }
}