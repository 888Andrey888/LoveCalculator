package com.example.lovecalculator

import android.util.Log
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import com.example.lovecalculator.view.LoveView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date

class Presenter(val loveView: LoveView) {

    private var api = RetrofitService().api

    fun getLoveResult(firstName: String, secondName: String) {
        api.calculateMatching(
            firstName,
            secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {
                    val loveModel = it
                    loveModel.time = Date().time
                    Log.d("ololo", "onResponse: ${loveModel.time}")
                    App.appDatabase.loveDao().insert(loveModel)
                    loveView.navigationToResult(loveModel)
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }
        })
    }
}