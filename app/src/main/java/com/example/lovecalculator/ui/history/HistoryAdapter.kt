package com.example.lovecalculator.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lovecalculator.databinding.ItemLoveHistoryBinding
import com.example.lovecalculator.model.LoveModel

class HistoryAdapter(
    val onClickItem: (loveModel: LoveModel) -> Unit,
    val onLongClickItem: (loveModel: LoveModel) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private val list = arrayListOf<LoveModel>()

    fun addLoveHistory(loveModels: List<LoveModel>) {
        list.clear()
        list.addAll(loveModels)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemLoveHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class ViewHolder(private var binding: ItemLoveHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loveHistory: LoveModel) = with(binding) {
            tvFirstName.text = loveHistory.firstName
            tvSecondName.text = loveHistory.secondName
            tvPercentage.text = loveHistory.percentage
            tvResult.text = loveHistory.result

            itemView.setOnClickListener {
                onClickItem(loveHistory)
            }

            itemView.setOnLongClickListener {
                onLongClickItem(loveHistory)
                true
            }
        }
    }
}