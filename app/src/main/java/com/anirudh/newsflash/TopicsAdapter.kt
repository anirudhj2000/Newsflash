package com.anirudh.newsflash

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class TopicsAdapter (var topicList : MutableList<TopicCard>) : RecyclerView.Adapter<TopicsAdapter.TopicViewHolder>() {

    inner class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.topic_item,parent,false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.itemView.apply {
            findViewById<TextView>(R.id.title).text = topicList[position].title
            if(topicList[position].favourtie){
                findViewById<ImageView>(R.id.favIcon).setImageResource(R.drawable.ic_baseline_favorite_24)
            }
            else{
                findViewById<ImageView>(R.id.favIcon).setImageResource(R.drawable.ic_outline_favorite_border_24)
            }
        }

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(topicList[position])
        }
    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    var onItemClick : ((TopicCard) -> Unit)? = null


}