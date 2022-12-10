package br.com.fundatec.jogoHoje.data.remote

import br.com.fundatec.RetrofitNetworkClient

import br.com.fundatec.jogoHoje.domain.usecase.TransactionModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TransactionRemoteDataSource {

    private val service =
        RetrofitNetworkClient.createNetworkClient().create(JogoHojeApi::class.java)

    suspend fun getTransactions(): ResultModel<List<TransactionModel>, ErrorModel> {
        return withContext(Dispatchers.IO) {
            try {
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
