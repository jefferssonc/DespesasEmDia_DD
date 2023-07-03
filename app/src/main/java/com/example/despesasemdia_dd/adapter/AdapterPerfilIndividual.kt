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
import org.w3c.dom.Text

class AdapterPerfilIndividuall(private val context: Context,private val items: MutableList<Despesas>): RecyclerView.Adapter<AdapterPerfilIndividuall.PerfilViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
        //Cria a visualização
        val itemLista = LayoutInflater.from(context).inflate(R.layout.pag_inicial_list,parent,false)
        val holder = PerfilViewHolder(itemLista)
        return holder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
        //exibe as views tralalal
        holder.preco.text = items[position].preco
        holder.data.text = items[position].data
        holder.nome.text = items[position].nome
    }

    inner class PerfilViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val data = itemView.findViewById<TextView>(R.id.dataPerfilIndividual)
        val preco = itemView.findViewById<TextView>(R.id.Valor_Total_Pag_Inicial)
        val nome = itemView.findViewById<TextView>(R.id.despesasPerfilIndividual)
    }
}