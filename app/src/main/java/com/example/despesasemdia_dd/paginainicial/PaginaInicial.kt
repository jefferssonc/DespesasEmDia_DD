package com.example.despesasemdia_dd.paginainicial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R

class PaginaInicial : AppCompatActivity() {

//    private val user = FirebaseAuth.getInstance().currentUser
//    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagina_inicial)

//        irParaPerfil()
//        irParaConfg()
//        irParaAdd()
//
//
//        val recyclerView_despesas_inicial = findViewById<RecyclerView>(R.id.recyclerView_despesas_inicial)
//        recyclerView_despesas_inicial.layoutManager = LinearLayoutManager(this)
//        recyclerView_despesas_inicial.setHasFixedSize(true)
//        //configurando adapter
//        val listaPagIncial :MutableList<Despesas> = mutableListOf()
//        val adapterPagInicial = AdapterPagInicial(this,listaPagIncial)
//
//        //criando items
//
//        val collectionRef = db.collection("Despesas")
//
//        collectionRef.whereEqualTo("Conta", user?.displayName).get()
//            .addOnSuccessListener { querySnapshot ->
//
//                for (document in querySnapshot) {
//                    val valor = document.getLong("Valor")
//                    val nome = document.getString("Nome")
//                    recyclerView_despesas_inicial.adapter = adapterPagInicial
//                    val icone = when (nome.toString()) {
//                        "Alimentacao" -> {
//                                R.drawable.comida_icon
//                        }
//                        "Transporte" -> {
//                                R.drawable.despesa_transporte_icon
//                        }
//                        "Educacao" -> {
//                            R.drawable.despesaeducacao_icon
//                        }
//                        "Saude" -> {
//                            R.drawable.despesasaude_icon
//                        }
//                        "Lazer" -> {
//                            R.drawable.despesalazer_icon
//                        }
//                        "Residencia" -> {
//                            R.drawable.home_house_icon
//                        }
//                        else -> {
//                                R.drawable.despesaoutros_icon
//                        }
//                    }
//
//                    val despesa = Despesas(
//                        nome = nome.toString(),
//                        icon = icone,
//                        preco = valor.toString(),
//                        data = null
//                    )
//                    listaPagIncial.add(despesa)
//
////                    if (nome.toString() == "Alimentação") {
////                        val despesa = Despesas(
////                            nome = nome.toString(),
////                            icon = R.drawable.comida_icon,
////                            preco = valor.toString(),
////                            data = null
////                        )
////                        listaPagIncial.add(despesa)
////                    }
////                    if (nome.toString() == "Transporte") {
////                        val despesa = Despesas(
////                            nome = nome.toString(),
////                            icon = R.drawable.despesa_transporte_icon,
////                            preco = valor.toString(),
////                            data = null
////                        )
////                        listaPagIncial.add(despesa)
////                    }
//
//                }
//            }
//    }
//
//    @SuppressLint("SetTextI18n")
//    fun somaDespesa(){
//        val collectionRef = db.collection("Despesas")
//
//
//        collectionRef.whereEqualTo("Conta", user?.displayName).get()
//            .addOnSuccessListener { querySnapshot ->
//                var soma = 0
//
//                for (document in querySnapshot) {
//                    val valor = document.getLong("Valor")?.toInt() ?: 0
//                    soma += valor
//                }
//
//                val txtdespesa = findViewById<TextView>(R.id.GASTO_TOTAL_PAG_INICIAL)
//                txtdespesa.text = "R$ $soma "
//            }
//
//    }
//    private fun irParaPerfil(){
//        val btvoltar = findViewById<ImageButton>(R.id.imageButton4)
//
//        btvoltar.setOnClickListener{view ->
//            val intent = Intent(this, PerfilIndividual::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun irParaAdd(){
//        val btvoltar = findViewById<ImageButton>(R.id.imageButton6)
//
//        btvoltar.setOnClickListener{view ->
//            val intent = Intent(this, AdicionarDespesa::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun irParaConfg(){
//        val btvoltar = findViewById<ImageButton>(R.id.imageButton9)
//
//        btvoltar.setOnClickListener{view ->
//            val intent = Intent(this, ConfigConta::class.java)
//            startActivity(intent)
//        }
//    }
//
//    override fun onStart() {
//        super.onStart()
//        val txtnome = findViewById<TextView>(R.id.textView21)
//        val username = user?.displayName
//        txtnome.text = username
//        somaDespesa()
    }
}