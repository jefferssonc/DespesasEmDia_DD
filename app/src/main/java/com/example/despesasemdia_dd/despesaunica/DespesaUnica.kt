package com.example.despesasemdia_dd.despesaunica

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despesasemdia_dd.R
import com.example.despesasemdia_dd.adapter.AdapterDespesaUnica
import com.example.despesasemdia_dd.model.DespesaUnicaDC
import com.google.firebase.firestore.FirebaseFirestore

class DespesaUnica : AppCompatActivity() {

    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesa_unica)

       //val valortxt = findViewById<EditText>(R.id.textValorDespesaUnica)



        val recyclerDespesaUnica = findViewById<RecyclerView>(R.id.recyclewViewDespesaUnica)
        recyclerDespesaUnica.layoutManager = LinearLayoutManager(this)
        recyclerDespesaUnica.setHasFixedSize(true)

        //Configurar adapter
        val itensListaDespesasUnicas: MutableList<DespesaUnicaDC> = mutableListOf()
        val adapterDespesasUnicas = AdapterDespesaUnica(this, itensListaDespesasUnicas)
        recyclerDespesaUnica.adapter = adapterDespesasUnicas

        val docRef = db.collection("Despesas").document("Lazer")

        docRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val document = task.result
                if (document != null && document.exists()) {
                    // O documento existe e você pode acessar os dados
                    val valor = document.getString("Valor")
                recyclerDespesaUnica.adapter = adapterDespesasUnicas
                //valortxt.text = valor.toString()
                val despesa = DespesaUnicaDC(valor.toString())
                itensListaDespesasUnicas.add(despesa)
//        val despesa2 = DespesaUnicaDC(00.25)
//        val despesa3 = DespesaUnicaDC(150.95)
//        itensListaDespesasUnicas.add(despesa1)
//        itensListaDespesasUnicas.add(despesa2)
//        itensListaDespesasUnicas.add(despesa3)
            }
            }
        }
    }
}