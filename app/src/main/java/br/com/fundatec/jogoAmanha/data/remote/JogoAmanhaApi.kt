package br.com.fundatec.jogoAmanha.data.remote


import retrofit2.http.GET

interface JogoAmanhaApi {

    @GET("/v1/jogos/amanha")
    suspend fun getJogosAmanha(): List<TransactionResponse>
}