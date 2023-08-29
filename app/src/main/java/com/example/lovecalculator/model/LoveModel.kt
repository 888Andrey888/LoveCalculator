package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName: String,
    var percentage: String,
    var result: String,
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var time: Long
) : Serializable
