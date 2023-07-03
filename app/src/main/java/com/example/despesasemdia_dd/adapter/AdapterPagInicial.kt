package com.example.despesasemdia_dd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.model.Despesas

class AdapterPagInicial(private val context: Context,private val items: MutableList<Despesas>): RecyclerView.Adapter<AdapterPagInicial.PerfilViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
        //Cria a visualização
        val itemLista = LayoutInflater.from(context).inflate(R.layout.pag_inicial_list,parent,false)
        val holder = PerfilViewHolder(itemLista)
        return holder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
        //exibe as views tralalal
        holder.icons.setImageResource(items[position].icon)
        holder.preco.text = items[position].preco

    }

    inner class PerfilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icons = itemView.findViewById<ImageView>(R.id.Despesa_Button_Pag_Inicial)
        val preco = itemView.findViewById<TextView>(R.id.Valor_Total_Pag_Inicial)

    }
}