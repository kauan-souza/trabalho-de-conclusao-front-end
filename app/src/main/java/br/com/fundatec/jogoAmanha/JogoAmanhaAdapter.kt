package br.com.fundatec.jogoAmanha

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fundatec.databinding.ItemListBinding
import br.com.fundatec.jogoAmanha.domain.usecase.TransactionModel

class JogoAmanhaAdapter() : RecyclerView.Adapter<JogoAmanhaViewHolder>() {

    private val listItem: MutableList<TransactionModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JogoAmanhaViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JogoAmanhaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JogoAmanhaViewHolder, position: Int) {
        val item = listItem[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun addList(list: List<TransactionModel>) {
        listItem.addAll(list)
    }

}

class JogoAmanhaViewHolder(
    private val binding: ItemListBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(transaction: TransactionModel) {
        binding.tvTimeMandante.text = transaction.timeMandante
        binding.tvTimeVisitante.text = transaction.timeVisitante
        binding.tvHorario.text = transaction.horario
        binding.tvTransmissao.text = transaction.transmissao.toString()
    }
}