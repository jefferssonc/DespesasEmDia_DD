package com.example.despesasemdia_dd.despesas

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesas
import com.example.despesasemdia_dd.adicionardespesa.AdicionarDespesa
import com.example.despesasemdia_dd.model.Despesass
import com.example.despesasemdia_dd.perfilindividual.PerfilIndividual
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Despesas : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()
    private val user = FirebaseAuth.getInstance().currentUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesas)


        irParaAdd()
        voltarParaPrincipal()
        voltar()

        val recyclerView_despesas = findViewById<RecyclerView>(R.id.recyclerPagDespesas)
        recyclerView_despesas.layoutManager = LinearLayoutManager(this)
        recyclerView_despesas.setHasFixedSize(true)
        //config
        val listaDespesas: MutableList<Despesass> = mutableListOf()
        val adapterDespesas = AdapterDespesas(this,listaDespesas)


        val collectionRef = db.collection("Despesas")

        collectionRef.whereEqualTo("Conta", user?.displayName).get()
            .addOnSuccessListener { querySnapshot ->

                for (document in querySnapshot) {
                   // val valor = document.getLong("Valor")
                    val nome = document.getString("Nome")
                    recyclerView_despesas.adapter = adapterDespesas
                    val icone = when (nome.toString()) {
                        "Alimentacao" -> {
                            R.drawable.comida_icon
                        }
                        "Transporte" -> {
                            R.drawable.despesa_transporte_icon
                        }
                        "Educacao" -> {
                            R.drawable.despesaeducacao_icon
                        }
                        "Saude" -> {
                            R.drawable.despesasaude_icon
                        }
                        "Lazer" -> {
                            R.drawable.despesalazer_icon
                        }
                        "Residencia" -> {
                            R.drawable.home_house_icon
                        }
                        else -> {
                            R.drawable.despesaoutros_icon
                        }
                    }
                    val despesa = Despesass(nome.toString(),
                        icone)

                    listaDespesas.add(despesa)
                }
            }


//        val despesa1 = Despesass(
//            "Alimentação",
//            R.drawable.comida_icon
//        )
//        listaDespesas.add(despesa1)
//        val despesa2 = Despesass(
//            "Alimentação",
//            R.drawable.comida_icon
//        )
//        listaDespesas.add(despesa2)
//        val despesa3 = Despesass(
//            "Alimentação",
//            R.drawable.comida_icon
//        )
//        listaDespesas.add(despesa3)
    }
    private fun voltar(){
        val btvoltar = findViewById<ImageButton>(R.id.imageButton)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, PerfilIndividual::class.java)
            startActivity(intent)
        }
    }

    private fun voltarParaPrincipal(){
        val btvoltar = findViewById<ImageButton>(R.id.imageButton8)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, PerfilIndividual::class.java)
            startActivity(intent)
        }
    }

    private fun irParaAdd(){
        val btvoltar = findViewById<ImageButton>(R.id.imageButton12)

        btvoltar.setOnClickListener{view ->
            val intent = Intent(this, AdicionarDespesa::class.java)
            startActivity(intent)
        }
    }

}