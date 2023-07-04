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



class AdapterPagDespesa(private val context: Context, private val items: MutableList<Despesas>): RecyclerView.Adapter<AdapterPagDespesa.PerfilViewHolder>() {


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
            //Cria a visualização
            val itemLista = LayoutInflater.from(context).inflate(R.layout.pag_inicial_list,parent,false)
            val holder = PerfilViewHolder(itemLista)
            return holder
        }

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
            //exibe as views tralalal
            items[position].icon?.let { holder.icons.setImageResource(it) }
            holder.nome.text = items[position].preco


        }

        inner class PerfilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val icons = itemView.findViewById<ImageView>(R.id.DespesaIconButton)
            val nome = itemView.findViewById<TextView>(R.id.NomeDespesa_pag_despesa)

        }
    }
