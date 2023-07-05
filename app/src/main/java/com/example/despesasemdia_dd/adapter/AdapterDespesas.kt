package com.example.despesasemdia_dd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.model.Despesass

class AdapterDespesas(private val context: Context, private val despesas: MutableList<Despesass>): RecyclerView.Adapter<AdapterDespesas.DespesasViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesasViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.despesas_item, parent, false)
        val holder = DespesasViewHolder(itemLista)
        return holder
    }

    override fun getItemCount(): Int = despesas.size

    override fun onBindViewHolder(holder: DespesasViewHolder, position: Int) {
        holder.icon.setImageResource(despesas[position].icon)
        holder.nome.text = despesas[position].nome
    }

    inner class DespesasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val icon = itemView.findViewById<ImageView>(R.id.btnDespesas)
        val nome = itemView.findViewById<TextView>(R.id.despesaPagDespesas)

    }
}