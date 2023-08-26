package com.example.lovecalculator.view

import com.example.lovecalculator.model.LoveModel

interface LoveView {

    fun navigationToResult(loveModel: LoveModel)
    fun showError(message: String)
}