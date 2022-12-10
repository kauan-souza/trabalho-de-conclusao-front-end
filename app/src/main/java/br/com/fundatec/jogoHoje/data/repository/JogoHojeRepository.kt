package br.com.fundatec.jogoHoje.data.repository


import br.com.fundatec.jogoHoje.data.remote.ErrorModel
import br.com.fundatec.jogoHoje.data.remote.ResultModel
import br.com.fundatec.jogoHoje.data.remote.TransactionRemoteDataSource
import br.com.fundatec.jogoHoje.domain.usecase.TransactionModel

class JogoHojeRepository {

    private val dataSource by lazy {
        TransactionRemoteDataSource()
    }

    suspend fun getTransaction(): ResultModel<List<TransactionModel>, ErrorModel> {
        return dataSource.getTransactions()
    }

}