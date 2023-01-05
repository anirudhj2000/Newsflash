package com.anirudh.newsflash

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ProfileAdapter (var profileList : MutableList<ProfileListCard>) : RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    inner class ProfileViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var profileTitle:TextView = itemView.findViewById<TextView>(R.id.profileTitle)
        var profileDescription:TextView = itemView.findViewById<TextView>(R.id.profileDescription)
        var profileIcon:ImageView = itemView.findViewById<ImageView>(R.id.profileIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.profile_item,parent,false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        holder.itemView.apply {
            holder.profileIcon.setImageResource(profileList[position].icon)
            holder.profileTitle.text = profileList[position].title
            holder.profileDescription.text = profileList[position].description
        }
    }

    override fun getItemCount(): Int {
        return profileList.size
    }


}