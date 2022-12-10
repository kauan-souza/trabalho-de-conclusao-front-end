package br.com.fundatec.transaction.data.remote

import android.util.Log
import br.com.fundatec.RetrofitNetworkClient
import br.com.fundatec.transaction.domain.usecase.TransactionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionRemoteDataSource {

    private val service = RetrofitNetworkClient
        .createNetworkClient()
        .create(TransactionApi::class.java)

    suspend fun getTransactions(): ResultModel<List<TransactionModel>, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
                Log.e(service.getJogosHoje().toString(), "aqui")
                ResultModel.Success(service.getJogosHoje().mapResponseToModel())
            } catch (exception: Exception) {
                ResultModel.Error(ErrorModel.Network)
            }
        }
    }

    private fun List<TransactionResponse>.mapResponseToModel(): List<TransactionModel> {

        return map {
            TransactionModel(
                timeMandante = it.timeMandante,
                timeVisitante = it.timeVisitante,
                horario = it.horario,
                transmissao = it.transmissao,
            )
        }

    }



}
