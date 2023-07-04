package com.example.despesasemdia_dd.despesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterPagDespesa
import com.example.despesasemdia_dd.adapter.AdapterPagInicial
import com.example.despesasemdia_dd.model.Despesas

class Despesa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesa)

        val recyclerView_despesas = findViewById<RecyclerView>(R.id.recyclerView_despesa)
        recyclerView_despesas.layoutManager = LinearLayoutManager(this)
        recyclerView_despesas.setHasFixedSize(true)
        //configurando adapter
        val listaDespesa :MutableList<Despesas> = mutableListOf()
        val adapterPagDespesa = AdapterPagDespesa(this,listaDespesa)
        recyclerView_despesas.adapter = adapterPagDespesa

        //criando items da Despesa pag inicial

        val despesa1 = Despesas(
            "null",
            R.drawable.comida_icon,
            "",
            ""
        )
        listaDespesa.add(despesa1)
        val despesa2 = Despesas(
            "null",
            R.drawable.despesalazer_icon,
            "",
            ""
        )
        listaDespesa.add(despesa2)
        val despesa3 = Despesas(
            "null",
            R.drawable.despesa_transporte_icon,
            "",
            ""
        )
        listaDespesa.add(despesa3)
    }
}