package com.example.myblogs

import android.os.Bundle
import android.telephony.ims.RegistrationManager
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.myblogs.models.Post
import com.example.myblogs.repositories.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build()
        val postAPI: PostRepository = retrofit.create<PostRepository>(PostRepository::class.java)
        var postCall = postAPI.posts
        val context = this
        postCall.enqueue(object : Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.d("GET api",t.message.toString())
            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val listView = findViewById<ListView>(R.id.list_view)
                //val adapter =  PostAdapter(context, response as ArrayList<Post>)
                //listView.adapter = adapter
                println("data recieved")
            }

        })
    }




}

