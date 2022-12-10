package br.com.fundatec.jogoHoje.data.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TransactionResponse(
    val timeMandante: String,
    val timeVisitante: String,
    val horario: String,
    val transmissao: List<String>,
)

