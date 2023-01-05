package com.anirudh.newsflash

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import java.io.IOException
import java.net.URL

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TopicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class TopicsFragment : Fragment(R.layout.fragment_topics) {

    private lateinit var adapter: TopicsAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var topiclist : MutableList<TopicCard>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalizeData()

        recyclerView = view.findViewById<RecyclerView>(R.id.topicsRecycler)
        adapter = TopicsAdapter(topiclist)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this.context,3)


        adapter.onItemClick = {
            var topic = it.title
            Intent(this.context,NewsActivity::class.java).also {
                it.putExtra("topic",topic)
                startActivity(it)
            }
        }

    }

    private fun initalizeData(){
        topiclist = mutableListOf(
            TopicCard("markets",true),
            TopicCard("technology",true),
            TopicCard("view",true),
            TopicCard("pursuits",false),
            TopicCard("politics",true),
            TopicCard("green",true),
            TopicCard("citylab",true),
            TopicCard("businessweek",true),
            TopicCard("fixed-income",false),
            TopicCard("hyperdrive",true),
            TopicCard("cryptocurrencies",true),
            TopicCard("cryptocurrencies",true),
            TopicCard("wealth",true),
            TopicCard("latest",true),
            TopicCard("personalFinance",false),
            TopicCard("quickTake",true),
            TopicCard("world",true),
            TopicCard("industries",false),
            TopicCard("stocks",true),
            TopicCard("currencies",true),
        )
    }


}


