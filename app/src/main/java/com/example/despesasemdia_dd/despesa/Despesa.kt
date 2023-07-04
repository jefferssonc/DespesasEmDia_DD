package com.example.despesasemdia_dd.despesa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesa
import com.example.despesasemdia_dd.model.Despesa
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Despesa : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesa)

        val recyclerView_despesa = findViewById<RecyclerView>(R.id.recyclerView_despesa)
        recyclerView_despesa.layoutManager= LinearLayoutManager(this)
        recyclerView_despesa.setHasFixedSize(true)
        //Configuração do adapter
        val listaDespesa: MutableList<Despesa> = mutableListOf()
        val adapterDespesa = AdapterDespesa(this,listaDespesa)
        recyclerView_despesa.adapter = adapterDespesa

        //criando items

        val collectionRef = db.collection("Despesas")

        collectionRef.whereEqualTo("Conta", user?.displayName).get()
            .addOnSuccessListener { querySnapshot ->

                for (document in querySnapshot) {
                    val valor = document.getLong("Valor")
                    val nome = document.getString("Nome")
                    recyclerView_despesa.adapter = adapterDespesa
                    val despesa = Despesa(nome = nome.toString())
                    despesa.preco = valor.toString()
                    despesa.imagem = R.drawable.home_house_icon

                    listaDespesa.add(despesa)
                }
            }


//        val despesa1 = Despesa(nome = "Residencia")
//        despesa1.imagem = R.drawable.home_house_icon
//        despesa1.preco = ""
//        listaDespesa.add(despesa1)
//
//        val despesa2 = Despesa(nome = "Alimentação")
//        despesa2.imagem = R.drawable.comida_icon
//        despesa2.preco = ""
//        listaDespesa.add(despesa2)
//
//        val despesa3 = Despesa(nome = "Transporte")
//        despesa3.imagem = R.drawable.despesa_transporte_icon
//        despesa3.preco = ""
//        listaDespesa.add(despesa3)
//
//        val despesa4 = Despesa(nome = "Saúde")
//        despesa4.imagem = R.drawable.despesasaude_icon
//        despesa4.preco = ""
//        listaDespesa.add(despesa4)
//
//        val despesa5 = Despesa(nome = "Diversão")
//        despesa5.imagem = R.drawable.despesalazer_icon
//        despesa5.preco = ""
//        listaDespesa.add(despesa5)
//
//        val despesa6 = Despesa(nome = "Educação")
//        despesa6.imagem = R.drawable.despesaeducacao_icon
//        despesa6.preco = ""
//        listaDespesa.add(despesa6)
//
//        val despesa7 = Despesa(nome = "Outros")
//        despesa7.imagem = R.drawable.despesaoutros_icon
//        despesa7.preco = ""
//        listaDespesa.add(despesa7)
    }
}