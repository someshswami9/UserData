package com.someshswami.userdatataskapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class UserAdapter(private var userList: UserData, private val context: Context): RecyclerView.Adapter<UserInfoHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.user_item,parent,false)
        return UserInfoHolder(view)
    }

    override fun onBindViewHolder(holder: UserInfoHolder, position: Int) {
        holder.userFirstName.text = userList.results[position].name.first
        holder.userThirdName.text = userList.results[position].name.last
        holder.gender.text = userList.results[position].gender
        holder.phone.text = userList.results[position].phone
        holder.location.text = userList.results[position].location.city

        Glide.with(context).load(userList.results[position].picture.medium).into(holder.userProfile)

        holder.itemView.setOnClickListener {
            holder.LinearLayout3.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return userList.results.size
    }



}
class UserInfoHolder(userItem : View) : RecyclerView.ViewHolder(userItem){
    val userProfile = userItem.findViewById<ImageView>(R.id.userProfile)
    val userFirstName = userItem.findViewById<TextView>(R.id.userFirstName)
    val userThirdName = userItem.findViewById<TextView>(R.id.userThirdName)
    val gender = userItem.findViewById<TextView>(R.id.gender)
    val phone = userItem.findViewById<TextView>(R.id.phone)
    val location = userItem.findViewById<TextView>(R.id.location)
    val  LinearLayout3 = userItem.findViewById<LinearLayout>(R.id.linearLayout3)
}

