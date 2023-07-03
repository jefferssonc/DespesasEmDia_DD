package com.example.despesasemdia_dd.paginainicial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterPagInicial
import com.example.despesasemdia_dd.model.Despesas

class PaginaInicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial)

        val recyclerView_despesas_inicial = findViewById<RecyclerView>(R.id.recyclerView_despesas_inicial)
        recyclerView_despesas_inicial.layoutManager = LinearLayoutManager(this)
        recyclerView_despesas_inicial.setHasFixedSize(true)
        //configurando adapter
        val listaPagIncial :MutableList<Despesas> = mutableListOf()
        val adapterPagInicial = AdapterPagInicial(this,listaPagIncial)
        recyclerView_despesas_inicial.adapter = adapterPagInicial

        //criando items da Despesa pag inicial

        val despesa1 = Despesas(
            "",
             R.drawable.comida_icon,
            "300,20"
        )
        listaPagIncial.add(despesa1)
        val despesa2 = Despesas(
            "",
            R.drawable.despesalazer_icon,
            "300,20"
        )
        listaPagIncial.add(despesa2)
        val despesa3 = Despesas(
            "",
            R.drawable.despesa_transporte_icon,
            "300,20"
        )
        listaPagIncial.add(despesa3)
    }
}