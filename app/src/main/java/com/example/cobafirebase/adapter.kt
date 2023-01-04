package com.example.cobafirebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class adapter (private val context: Context,private val users: List<model>) : RecyclerView.Adapter<UserViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {


        val user = users[position]
        holder.username.text = user.nama

        Glide.with(context)
            .load(user.userImage)
            .into(holder.userimage)
    }

    override fun getItemCount(): Int {
        return users.size
    }

}

class UserViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
    val username : TextView = itemView.findViewById(R.id.username)
    val userimage : ImageView = itemView.findViewById(R.id.imageView)
}
