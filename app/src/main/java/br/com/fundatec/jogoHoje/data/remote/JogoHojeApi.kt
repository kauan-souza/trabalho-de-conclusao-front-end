package br.com.fundatec.jogoHoje.data.remote

import retrofit2.http.GET

interface JogoHojeApi {

    @GET("/v1/jogos/hoje")
    suspend fun getJogosHoje(): List<TransactionResponse>
}