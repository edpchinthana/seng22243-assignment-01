package com.example.myblogs

import android.os.Bundle
import android.telephony.ims.RegistrationManager
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myblogs.models.Post
import com.example.myblogs.repositories.PostRepository
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = GsonBuilder().create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        val postAPI: PostRepository = retrofit.create<PostRepository>(PostRepository::class.java)
        var postCall = postAPI.posts
        postCall.enqueue(object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("GET api",t.message.toString())
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val listView = findViewById<ListView>(R.id.list_view)
                val adapter =  PostAdapter(this@MainActivity, response.body() as ArrayList<Post>)
                listView.adapter = adapter
                println("data recieved")
            }

        })
    }




}


