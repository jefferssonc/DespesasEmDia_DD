package com.example.despesasemdia_dd.perfilindividual

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.despesasemdia_dd.R
import com.google.firebase.auth.FirebaseAuth

class PerfilIndividual : AppCompatActivity() {

    private val user = FirebaseAuth.getInstance().currentUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_individual)

    }

//    private fun voltarParaPrincipal(voltar: String){
//        val btvoltar = findViewById<Button>(R.id.imageView5)
//
//        btvoltar.setOnClickListener{view ->
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
//            finish()
//        }
//    }

        override fun onStart() {
            super.onStart()
            val txtnome = findViewById<TextView>(R.id.NomeUserPerfIndividual)
            val username = user?.displayName
            txtnome.text = username
    }

}