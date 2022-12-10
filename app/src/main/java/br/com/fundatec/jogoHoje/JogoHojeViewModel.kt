package br.com.fundatec.jogoHoje

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.jogoHoje.data.remote.ErrorModel
import br.com.fundatec.jogoHoje.data.remote.ResultModel
import br.com.fundatec.jogoHoje.domain.usecase.GetJogoHojeUsecase
import br.com.fundatec.jogoHoje.domain.usecase.TransactionModel
import kotlinx.coroutines.launch

class JogoHojeViewModel : ViewModel() {

    private val usecase by lazy {
        GetJogoHojeUsecase()
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