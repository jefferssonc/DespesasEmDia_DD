package com.example.despesasemdia_dd.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class DespesaUnicaDC(val valor:String){
    val dataValorUnico: String = SimpleDateFormat("dd-MM-yyyy", Locale("pt", "BR")).format(Date())
}
