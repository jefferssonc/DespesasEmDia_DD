package com.example.despesasemdia_dd.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class DespesaIndividual(val nomeCategoria: String, val precoDespesa: Double) {

    val dataDespesa: String = SimpleDateFormat("dd-MM-yyyy", Locale("pt", "BR")).format(Date())
}
