package com.example.lovecalculator

import android.util.Log
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.view.HistoryView

class HistoryPresenter(private val historyView: HistoryView) {

    fun getHistoryList() {
        historyView.initRecyclerView(App.appDatabase.loveDao().getAll())
    }

    fun deleteItem(loveModel: LoveModel) {
        App.appDatabase.loveDao().delete(loveModel)
        getHistoryList()
    }

    fun getDate(loveModel: LoveModel) {
        Log.d("ololo", "getDate: ${loveModel.time}")
        loveModel.time?.let { historyView.showDateDialog(it) }
    }
}