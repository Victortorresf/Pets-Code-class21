package com.example.class_21jan

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    var list = ArrayList<Pet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofitClient = Client
            .getRetrofitInstance("http://10.0.2.2:3000/")
        val endpoint = retrofitClient.create(Routes::class.java)
        val callback = endpoint.getPets()

        callback.enqueue(object : Callback<List<Pet>> {
            override fun onFailure(call: Call<List<Pet>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            @SuppressLint("CutPasteId")
            override fun onResponse(call: Call<List<Pet>>, response: Response<List<Pet>>) {
                response.body()?.forEach { list.add(Pet(it.name,it.age,it.phhp,it.mehp));
            }
                findViewById<RecyclerView>(R.id.recyclerView).adapter = CustomAdaptor(list)
                findViewById<RecyclerView>(R.id.recyclerView).layoutManager = LinearLayoutManager(applicationContext)
                findViewById<RecyclerView>(R.id.recyclerView).setHasFixedSize(true)
            }
        })

        findViewById<Button>(R.id.button).setOnClickListener {
            var intent = Intent(this, AddPet::class.java)
            startActivity(intent)
        }
    }
}