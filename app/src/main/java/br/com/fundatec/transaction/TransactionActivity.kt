package br.com.fundatec.transaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.fundatec.TransactionAdapter
import br.com.fundatec.databinding.ActivityTransactionBinding
import br.com.fundatec.transaction.data.remote.ErrorModel

class TransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding
    private lateinit var viewModel: TransactionViewModel

    private val adapter: TransactionAdapter by lazy {
        TransactionAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        viewModel = TransactionViewModel()

        val view = binding.root
        setContentView(view)

        viewModel.transactionLiveData.observe(this) {

            binding.rcList.adapter = adapter
            it?.let {
                adapter.addList(it)
            }
        }

        viewModel.errorLiveData.observe(this) { it ->
            when (it) {
                ErrorModel.EmptyList -> showToast("Lista vazia")
                ErrorModel.Network -> showToast("Erro para conectar")
                else -> {}
            }
        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(
            this,
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
}