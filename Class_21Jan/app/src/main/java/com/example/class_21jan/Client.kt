package com.example.class_21jan

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Client {

    companion object {
        fun getRetrofitInstance(path: String): Retrofit {

            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create()) //Retrofit client can now convert to JSON
                .build()
        }
    }
}
