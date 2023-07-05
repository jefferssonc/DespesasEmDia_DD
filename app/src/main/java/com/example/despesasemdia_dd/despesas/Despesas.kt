package com.example.despesasemdia_dd.despesas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesas
import com.example.despesasemdia_dd.model.Despesass

class Despesas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesas)

        val recyclerView_despesas = findViewById<RecyclerView>(R.id.recyclerPagDespesas)
        recyclerView_despesas.layoutManager = LinearLayoutManager(this)
        recyclerView_despesas.setHasFixedSize(true)
        //config
        val listaDespesas: MutableList<Despesass> = mutableListOf()
        val adapterDespesas = AdapterDespesas(this,listaDespesas)
        recyclerView_despesas.adapter = adapterDespesas

        val despesa1 = Despesass(
            "Alimentação",
            R.drawable.comida_icon
        )
        listaDespesas.add(despesa1)
        val despesa2 = Despesass(
            "Alimentação",
            R.drawable.comida_icon
        )
        listaDespesas.add(despesa2)
        val despesa3 = Despesass(
            "Alimentação",
            R.drawable.comida_icon
        )
        listaDespesas.add(despesa3)
    }
}