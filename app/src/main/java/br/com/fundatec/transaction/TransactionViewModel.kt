package br.com.fundatec.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.transaction.data.remote.ErrorModel
import br.com.fundatec.transaction.data.remote.ResultModel
import br.com.fundatec.transaction.domain.usecase.GetTransactionUsecase
import br.com.fundatec.transaction.domain.usecase.TransactionModel
import kotlinx.coroutines.launch

class TransactionViewModel : ViewModel() {

    private val usecase by lazy {
        GetTransactionUsecase()
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