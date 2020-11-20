package com.example.myblogs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myblogs.models.Post

class PostAdapter(private val context: Context, private val dataSource: ArrayList<Post>): BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item, parent, false)
        val titleTextView = rowView.findViewById(R.id.title) as TextView
        val authorTextView = rowView.findViewById(R.id.author) as TextView

        val post = getItem(position) as Post
        titleTextView.text = post.title
        authorTextView.text = post.userId.toString()

        return rowView
    }


}