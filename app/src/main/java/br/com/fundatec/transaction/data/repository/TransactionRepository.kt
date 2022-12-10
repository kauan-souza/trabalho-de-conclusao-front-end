package br.com.fundatec.transaction.data.repository

import br.com.fundatec.transaction.data.remote.ErrorModel
import br.com.fundatec.transaction.data.remote.ResultModel
import br.com.fundatec.transaction.data.remote.TransactionRemoteDataSource
import br.com.fundatec.transaction.domain.usecase.TransactionModel

class TransactionRepository {

    private val dataSource by lazy {
        TransactionRemoteDataSource()
    }

    suspend fun getTransaction(): ResultModel<List<TransactionModel>, ErrorModel> {
        return dataSource.getTransactions()
    }

}