package com.example.myblogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myblogs.models.Post

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postList = mutableListOf<Post>()
        val post = Post(1,1,"title","body")
        postList.add(post)
        val listView = findViewById<ListView>(R.id.list_view)
        val adapter =  PostAdapter(this, postList as ArrayList<Post>)
        listView.adapter = adapter
    }




}
