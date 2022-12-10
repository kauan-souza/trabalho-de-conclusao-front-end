package br.com.fundatec.jogoHoje

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.databinding.ActivityTransactionBinding
import br.com.fundatec.jogoAmanha.JogoAmanhaActivity
import br.com.fundatec.jogoHoje.data.remote.ErrorModel

class JogoHojeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTransactionBinding
    private lateinit var viewModel: JogoHojeViewModel

    private val adapter: JogoHojeAdapter by lazy {
        JogoHojeAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionBinding.inflate(layoutInflater)
        viewModel = JogoHojeViewModel()

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
                ErrorModel.EmptyList -> showToast("Sem Jogos Para Exibir!")
                ErrorModel.Network -> showToast("Erro Inesperado!")
                else -> {}
            }
        }

        binding.btBack.setOnClickListener() {
            val intent = Intent(this, JogoAmanhaActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(
            this, msg, Toast.LENGTH_SHORT
        ).show()
    }
}