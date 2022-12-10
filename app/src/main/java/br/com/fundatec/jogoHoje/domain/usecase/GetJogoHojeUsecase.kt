package br.com.fundatec.jogoHoje.domain.usecase

import br.com.fundatec.jogoHoje.data.remote.ErrorModel
import br.com.fundatec.jogoHoje.data.remote.ResultModel
import br.com.fundatec.jogoHoje.data.repository.JogoHojeRepository


class GetJogoHojeUsecase {

    private val repository by lazy {
        JogoHojeRepository()
    }

    suspend fun getTransactions(
    ): ResultModel<List<TransactionModel>, ErrorModel> {
        return repository.getTransaction()
    }

}