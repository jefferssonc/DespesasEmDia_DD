package com.example.despesasemdia_dd.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.model.Despesa
import org.w3c.dom.Text

class AdapterDespesa(private val context: Context,private val despesas: MutableList<Despesa>): RecyclerView.Adapter<AdapterDespesa.DespesaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DespesaViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.despesa_list,parent,false)
        val holder = DespesaViewHolder(itemLista)
        return holder

    }
    override fun getItemCount(): Int = despesas.size
    override fun onBindViewHolder(holder: DespesaViewHolder, position: Int) {
        holder.foto.setImageResource(despesas[position].imagem)
        holder.nome.text = despesas[position].nome
        //holder.preco.text = despesas[position].preco
    }
    inner class DespesaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foto = itemView.findViewById<ImageView>(R.id.foto_despesa)
        val nome = itemView.findViewById<TextView>(R.id.nome_despesa)
        //val preco = itemView.findViewById<TextView>(R.id.preco)
    }
}