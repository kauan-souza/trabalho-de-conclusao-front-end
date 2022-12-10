package br.com.fundatec.jogoAmanha.domain.usecase

import br.com.fundatec.jogoAmanha.data.remote.ErrorModel
import br.com.fundatec.jogoAmanha.data.remote.ResultModel
import br.com.fundatec.jogoAmanha.data.repository.JogoAmanhaRepository

class GetJogoAmanhaUsecase {

    private val repository by lazy {
        JogoAmanhaRepository()
    }

    suspend fun getTransactions(
    ): ResultModel<List<TransactionModel>, ErrorModel> {
        return repository.getTransaction()
    }

}