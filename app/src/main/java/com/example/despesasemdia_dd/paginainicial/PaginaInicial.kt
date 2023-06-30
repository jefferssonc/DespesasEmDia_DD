package com.example.despesasemdia_dd.paginainicial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesa
import com.example.despesasemdia_dd.model.Despesa

class PaginaInicial : AppCompatActivity() {
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

        val despesa2 = Despesa(
            R.drawable.comida_icon,
            nome = "Alimentação",
            preco = ""
        )
        listaDespesas.add(despesa2)

        val despesa3 = Despesa(
            R.drawable.despesa_transporte_icon,
            nome = "Transporte",
            preco = ""
        )
        listaDespesas.add(despesa3)
        val despesa4 = Despesa(
            R.drawable.despesasaude_icon,
            nome = "Saúde",
            preco = ""
        )
        listaDespesas.add(despesa4)
        val despesa5 = Despesa(
            R.drawable.despesalazer_icon,
            nome = "Diversão",
            preco = ""
        )
        listaDespesas.add(despesa5)
        val despesa6 = Despesa(
            R.drawable.despesaeducacao_icon,
            nome = "Educação",
            preco = ""
        )
        listaDespesas.add(despesa6)
        val despesa7 = Despesa(
            R.drawable.despesaoutros_icon,
            nome = "Outros",
            preco = ""
        )
        listaDespesas.add(despesa7)
    }
}