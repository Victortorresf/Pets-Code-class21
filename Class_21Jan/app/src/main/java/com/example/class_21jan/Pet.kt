package com.example.class_21jan

import com.google.gson.annotations.SerializedName

data class Pet(
    @SerializedName("Name")
    val name:String,
    @SerializedName("Age")
    val age:Int,
    @SerializedName("PhyHP")
    val phhp:Int,
    @SerializedName("MenHP")
    val mehp:Int,
)