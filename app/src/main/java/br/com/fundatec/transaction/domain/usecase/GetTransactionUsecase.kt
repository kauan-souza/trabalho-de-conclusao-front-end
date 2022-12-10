package br.com.fundatec.transaction.domain.usecase

import br.com.fundatec.transaction.data.remote.ErrorModel
import br.com.fundatec.transaction.data.remote.ResultModel
import br.com.fundatec.transaction.data.repository.TransactionRepository

class GetTransactionUsecase {

    private val repository by lazy {
        TransactionRepository()
    }

    suspend fun getTransactions(
    ): ResultModel<List<TransactionModel>, ErrorModel> {
        return repository.getTransaction()
    }

}