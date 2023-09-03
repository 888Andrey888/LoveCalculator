package com.example.lovecalculator

import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.Pref
import com.example.lovecalculator.model.room.LoveDao
import com.example.lovecalculator.view.LoveView
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Date
import javax.inject.Inject

//@AndroidEntryPoint
class Presenter @Inject constructor(private val api: LoveApi) {

    private lateinit var loveView: LoveView

    @Inject
    lateinit var loveDao: LoveDao

    @Inject
    lateinit var pref: Pref

    fun getLoveResult(firstName: String, secondName: String) {
        api.calculateMatching(
            firstName,
            secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                response.body()?.let {
                    val loveModel = it
                    loveModel.time = Date().time
                    loveDao.insert(loveModel)
                    loveView.navigationToResult(loveModel)
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                loveView.showError(t.message.toString())
            }
        })
    }

    fun showOnBoarding(){
        if (!pref.isOnBoardingShowed())
            loveView.navigationToOnBoarding()
    }

    fun attachView(view: LoveView){
        loveView = view
    }
}