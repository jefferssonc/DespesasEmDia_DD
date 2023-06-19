package com.example.despesasemdia_dd.models


import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Despesas(val nome: String, val preco: Double) {

    val data: String = SimpleDateFormat("dd-MM-yyyy", Locale("pt", "BR")).format(Date())
}
