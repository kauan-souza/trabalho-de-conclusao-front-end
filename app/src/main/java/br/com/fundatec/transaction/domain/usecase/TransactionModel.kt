package br.com.fundatec.transaction.domain.usecase

import java.util.*

data class TransactionModel(
    val timeMandante: String,
    val timeVisitante: String,
    val horario: String,
    val transmissao: List<String>,
)
