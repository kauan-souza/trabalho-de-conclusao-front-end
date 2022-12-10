package br.com.fundatec.jogoAmanha

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.databinding.ActivityJogoAmanhaBinding
import br.com.fundatec.jogoAmanha.data.remote.ErrorModel
import br.com.fundatec.jogoHoje.JogoHojeActivity

class JogoAmanhaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityJogoAmanhaBinding
    private lateinit var viewModel: JogoAmanhaViewModel

    private val adapter: JogoAmanhaAdapter by lazy {
        JogoAmanhaAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJogoAmanhaBinding.inflate(layoutInflater)
        viewModel = JogoAmanhaViewModel()

        val view = binding.root
        setContentView(view)

        viewModel.transactionLiveData.observe(this) {

            binding.rcList2.adapter = adapter
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

        binding.btBack2.setOnClickListener() {
            val intent = Intent(this, JogoHojeActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showToast(msg: String) {
        Toast.makeText(
            this, msg, Toast.LENGTH_SHORT
        ).show()
    }
}