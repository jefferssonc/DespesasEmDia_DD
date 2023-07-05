package com.example.despesasemdia_dd.despesaunica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesaUnica
import com.example.despesasemdia_dd.model.DespesaUnicaDC

class DespesaUnica : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesa_unica)

        val recyclerDespesaUnica = findViewById<RecyclerView>(R.id.recyclewViewDespesaUnica)
        recyclerDespesaUnica.layoutManager = LinearLayoutManager(this)
        recyclerDespesaUnica.setHasFixedSize(true)

        //Configurar adapter
        val itensListaDespesasUnicas:MutableList<DespesaUnicaDC> = mutableListOf()
        val adapterDespesasUnicas = AdapterDespesaUnica(this,itensListaDespesasUnicas)
        recyclerDespesaUnica.adapter = adapterDespesasUnicas

        val despesa1 = DespesaUnicaDC(10.25)
        val despesa2 = DespesaUnicaDC(00.25)
        val despesa3 = DespesaUnicaDC(150.95)
        itensListaDespesasUnicas.add(despesa1)
        itensListaDespesasUnicas.add(despesa2)
        itensListaDespesasUnicas.add(despesa3)
    }
}