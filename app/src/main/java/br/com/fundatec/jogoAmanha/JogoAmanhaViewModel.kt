package br.com.fundatec.jogoAmanha

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.jogoAmanha.data.remote.ErrorModel
import br.com.fundatec.jogoAmanha.data.remote.ResultModel
import br.com.fundatec.jogoAmanha.domain.usecase.GetJogoAmanhaUsecase
import br.com.fundatec.jogoAmanha.domain.usecase.TransactionModel

import kotlinx.coroutines.launch

class JogoAmanhaViewModel : ViewModel() {

    private val usecase by lazy {
        GetJogoAmanhaUsecase()
    }

    private val transaction: MutableLiveData<List<TransactionModel>?> = MutableLiveData()
    val transactionLiveData: LiveData<List<TransactionModel>?> = transaction

    private val error: MutableLiveData<ErrorModel?> = MutableLiveData()
    val errorLiveData: LiveData<ErrorModel?> = error

    init {
        getTransaction()
    }


    private fun getTransaction() {
        viewModelScope.launch {

            val resultTransactions = usecase.getTransactions()

            if (resultTransactions is ResultModel.Success) {
                transaction.value = resultTransactions.value

                if(resultTransactions.value.isEmpty()){
                    error.value = ErrorModel.EmptyList
                }
            } else if (resultTransactions is ResultModel.Error) {
                error.value = resultTransactions.value
            }
        }

    }

}