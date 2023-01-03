package com.anirudh.newsflash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarMenu
import com.google.android.material.navigation.NavigationBarView

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_home)

        var topicsfragment = TopicsFragment()
        var newsFragment = NewsFragment()
        var profileFragment = ProfileFragment()

        findViewById<BottomNavigationView>(R.id.bottomNavigation).setOnItemSelectedListener{
            when(it.itemId){
                R.id.topic -> setCurrentFragment(topicsfragment)
                R.id.news ->  setCurrentFragment(newsFragment)
                R.id.profile ->  setCurrentFragment(profileFragment)
            }
            return@setOnItemSelectedListener true
        }
    }

    fun setCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flView,fragment)
            commit()
        }
    }
}