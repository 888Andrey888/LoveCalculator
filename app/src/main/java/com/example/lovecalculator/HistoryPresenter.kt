package com.example.lovecalculator

import android.util.Log
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.room.LoveDao
import com.example.lovecalculator.view.HistoryView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class HistoryPresenter @Inject constructor(private val loveDao: LoveDao) {

    private lateinit var historyView: HistoryView
    fun getHistoryList() {
        historyView.initRecyclerView(loveDao.getAll())
    }

    fun deleteItem(loveModel: LoveModel) {
        loveDao.delete(loveModel)
        getHistoryList()
    }

    fun getDate(loveModel: LoveModel) {
        loveModel.time?.let { historyView.showDateDialog(it) }
    }

    fun attachView(view: HistoryView){
        historyView = view
    }
}