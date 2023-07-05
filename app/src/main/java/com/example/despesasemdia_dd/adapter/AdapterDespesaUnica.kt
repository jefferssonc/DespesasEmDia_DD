package com.example.despesasemdia_dd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.model.DespesaUnicaDC

class AdapterDespesaUnica(private val context: Context, private val despesasItems:MutableList<DespesaUnicaDC>):RecyclerView.Adapter<AdapterDespesaUnica.DespesaUnicaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesaUnicaViewHolder {
        val itemDespesaUnica = LayoutInflater.from(context).inflate(R.layout.despesa_unica_item,parent,false)
        val holderUnica = DespesaUnicaViewHolder(itemDespesaUnica)
        return holderUnica
    }

    override fun getItemCount(): Int {
    return despesasItems.size
    }

    override fun onBindViewHolder(holder: DespesaUnicaViewHolder, position: Int) {
        val despesaunica = despesasItems[position]
        holder.bind(despesaunica)
    }
    inner class DespesaUnicaViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            val valorDespesaItem = itemView.findViewById<TextView>(R.id.textValorDespesaUnicaItem)
            val dataDespesaItem = itemView.findViewById<TextView>(R.id.textDataDespesaUnicaItem)
        fun bind(despesaunica : DespesaUnicaDC){
            valorDespesaItem.text = despesaunica.valor.toString()
            dataDespesaItem.text = despesaunica.dataValorUnico
        }
    }
}