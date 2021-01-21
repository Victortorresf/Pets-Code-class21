package com.example.class_21jan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddPet : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.addpet)

        findViewById<Button>(R.id.addpet).setOnClickListener {
            var name: Editable? = findViewById<EditText>(R.id.name).text
            var age: Editable? = findViewById<EditText>(R.id.age).text
            var phhp: Editable? = findViewById<EditText>(R.id.phhp).text
            var mehp: Editable? = findViewById<EditText>(R.id.mehp).text

            val pet = Pet(name.toString(), age.toString().toInt(), phhp.toString().toInt(), mehp.toString().toInt())
            addPet(pet) {
                if (it?.name != null) {
                    Log.d("OKKK", "OKKK")
                } else {
                    Log.d("ERROOOOOORRRR", "ERROOOORRRRR")
                }
            }
        }

        findViewById<Button>(R.id.main).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun addPet(pet: Pet, onResult: (Pet?) -> Unit) {
        val retrofitClient = Client
            .getRetrofitInstance("http://10.0.2.2:3000/")
        val endpoint = retrofitClient.create(Routes::class.java)
        endpoint.newPet(pet).enqueue(
            object : Callback<Pet> {
                override fun onFailure(call: Call<Pet>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }
            }
        )
    }
}