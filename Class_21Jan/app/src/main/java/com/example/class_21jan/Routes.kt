package com.example.class_21jan

import retrofit2.Call
import retrofit2.http.*

interface Routes {
    @GET("getPets")
    fun getPets() : Call<List<Pet>>

    @POST("newPet")
    fun newPet(@Body userData: Pet): Call<Pet>
}