package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface HistoryView {
    fun initRecyclerView(historyList: List<LoveModel>)

    fun showDeleteDialog(loveModel: LoveModel)

    fun showDateDialog(time: Long)
}