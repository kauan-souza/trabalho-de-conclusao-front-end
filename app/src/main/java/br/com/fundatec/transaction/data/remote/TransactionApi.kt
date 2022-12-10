package br.com.fundatec.transaction.data.remote

import retrofit2.http.GET

interface TransactionApi {

    @GET("/v1/jogos/hoje")
    suspend fun getJogosHoje(): List<TransactionResponse>
}