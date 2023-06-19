package com.example.despesasemdia_dd.model
import java.text.SimpleDateFormat
import java.util.Date

data class Despesa(
    val imagem: Int,
    val nome: String,
    val preco: String,
    //val data: String = SimpleDateFormat("dd, MMMM, yyyy").format(Date())
)

