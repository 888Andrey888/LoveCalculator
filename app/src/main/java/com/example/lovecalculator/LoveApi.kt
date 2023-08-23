package com.example.lovecalculator

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculateMatching(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "b72b475cb6msh6a657c77c266be1p13616ajsnc79f105c8084",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
    ) : Call<LoveModel>
}