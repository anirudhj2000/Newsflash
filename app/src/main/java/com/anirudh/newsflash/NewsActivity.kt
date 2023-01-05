package com.anirudh.newsflash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.*
import java.io.IOException

class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_news)

        var client = OkHttpClient()
        var topic: String? = null

        topic = intent.extras?.get("topic").toString()

        val request = Request.Builder()
            .url("https://bloomberg-market-and-financial-news.p.rapidapi.com/news/list?id=$topic")
            .get()
            .addHeader("X-RapidAPI-Key", "3d365a9107mshc7b4c65833366b9p19e38fjsn944f9247c9df")
            .addHeader("X-RapidAPI-Host", "bloomberg-market-and-financial-news.p.rapidapi.com")
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                if(!response.isSuccessful){
                    throw IOException("Error $response")
                }
                else{

                }
            }

        })


    }
}