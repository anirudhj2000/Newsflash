package com.anirudh.newsflash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization param

/**
 * A simple [Fragment] subclass.
 * Use the [TopicsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment(R.layout.fragment_profile) {
    // TODO: Rename and change types of parametersxx

    private lateinit var adapter: ProfileAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var profileItemList : MutableList<ProfileListCard>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeData()

        recyclerView = view.findViewById<RecyclerView>(R.id.profileRecycler)
        adapter = ProfileAdapter(profileItemList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.context)

    }

    private fun initializeData(){
        profileItemList = mutableListOf(
            ProfileListCard("Notifications","manage your notifications",R.mipmap.profile),
            ProfileListCard("Feedback","share your feedback",R.mipmap.profile),
            ProfileListCard("Autoplay","toggle autoplay for news",R.mipmap.profile),
            ProfileListCard("Share this app","please share the app with your friends",R.mipmap.profile),
        )
    }

}