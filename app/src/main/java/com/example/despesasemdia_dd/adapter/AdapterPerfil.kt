package com.example.despesasemdia_dd.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.model.DespesaIndividual
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class AdapterPerfil(private val context : Context, private val despesaPerfil:MutableList<DespesaIndividual>):RecyclerView.Adapter<AdapterPerfil.PerfilViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
        val itemPerfil = LayoutInflater.from(context).inflate(R.layout.pag_perfil_individual_list,parent,false)
        val holderPerfil = PerfilViewHolder(itemPerfil)
        return holderPerfil
    }
    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
        val despesa = despesaPerfil[position]
        holder.bind(despesa)

    }
    override fun getItemCount(): Int { return despesaPerfil.size }
    inner class PerfilViewHolder (itemView : View):RecyclerView.ViewHolder(itemView){

        val categoria = itemView.findViewById<TextView>(R.id.despesasPerfilIndividual)
        val botao  = itemView.findViewById<ImageButton>(R.id.deletePerfilIndividual)
        val dataDespe = itemView.findViewById<TextView>(R.id.dataPerfilIndividual)
        val valorDespesa = itemView.findViewById<TextView>(R.id.valorPerfilIndividual)
        fun bind(despesa : DespesaIndividual){
            categoria.text = despesa.nomeCategoria
            dataDespe.text = despesa.dataDespesa
            valorDespesa.text = despesa.precoDespesa.toString()

            botao.setOnClickListener{view->
                val db = FirebaseFirestore.getInstance()
                val user = FirebaseAuth.getInstance().currentUser
                val docRef = db.collection("Despesas").document(categoria.text.toString() + user?.displayName)
                docRef.delete().addOnSuccessListener {
                    val snackbar =
                    Snackbar.make(view, "Despesa deletada. Atualize a página", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.GREEN)
                    snackbar.show()
                }
            }
        }


    }
}