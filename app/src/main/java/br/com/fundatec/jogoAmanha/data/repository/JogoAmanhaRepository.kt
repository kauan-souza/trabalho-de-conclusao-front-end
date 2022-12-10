package br.com.fundatec.jogoAmanha.data.repository

import br.com.fundatec.jogoAmanha.data.remote.ErrorModel
import br.com.fundatec.jogoAmanha.data.remote.ResultModel
import br.com.fundatec.jogoAmanha.data.remote.TransactionRemoteDataSource
import br.com.fundatec.jogoAmanha.domain.usecase.TransactionModel


class JogoAmanhaRepository {

    private val dataSource by lazy {
        TransactionRemoteDataSource()
    }

    suspend fun getTransaction(): ResultModel<List<TransactionModel>, ErrorModel> {
        return dataSource.getTransactions()
    }

}