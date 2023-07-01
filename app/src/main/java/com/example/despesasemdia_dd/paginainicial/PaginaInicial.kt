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
        val despesa1 = Despesa(nome = "Residencia")
        despesa1.imagem = R.drawable.home_house_icon
        despesa1.preco = ""
        listaDespesas.add(despesa1)

        val despesa2 = Despesa(nome = "Alimentação")
        despesa2.imagem = R.drawable.comida_icon
        despesa2.preco = ""
        listaDespesas.add(despesa2)

        val despesa3 = Despesa(nome = "Transporte")
            despesa3.imagem = R.drawable.despesa_transporte_icon
            despesa3.preco = ""
        listaDespesas.add(despesa3)

        val despesa4 = Despesa(nome = "Saúde")
        despesa4.imagem = R.drawable.despesasaude_icon
        despesa4.preco = ""
        listaDespesas.add(despesa4)

        val despesa5 = Despesa(nome = "Diversão")
        despesa5.imagem = R.drawable.despesalazer_icon
        despesa5.preco = ""
        listaDespesas.add(despesa5)

        val despesa6 = Despesa(nome = "Educação")
        despesa6.imagem = R.drawable.despesaeducacao_icon
        despesa6.preco = ""
        listaDespesas.add(despesa6)

        val despesa7 = Despesa(nome = "Outros")
        despesa7.imagem = R.drawable.despesaoutros_icon
        despesa7.preco = ""
        listaDespesas.add(despesa7)
    }
}