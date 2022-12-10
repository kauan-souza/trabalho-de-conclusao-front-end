package br.com.fundatec.jogoAmanha.domain.usecase

data class TransactionModel(
    val timeMandante: String,
    val timeVisitante: String,
    val horario: String,
    val transmissao: List<String>,
)
