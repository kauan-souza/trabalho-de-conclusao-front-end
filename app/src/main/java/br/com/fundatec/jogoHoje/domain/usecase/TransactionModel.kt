package br.com.fundatec.jogoHoje.domain.usecase

data class TransactionModel(
    val timeMandante: String,
    val timeVisitante: String,
    val horario: String,
    val transmissao: List<String>,
)
