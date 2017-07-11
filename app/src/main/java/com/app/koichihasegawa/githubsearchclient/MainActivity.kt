package com.app.koichihasegawa.githubsearchclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = GitApiServiceGenerator.createService()
        val call = service.search("kotlin")
        call.enqueue(object : retrofit2.Callback<GitApiResponse> {
            override fun onResponse(call: Call<GitApiResponse>?, response: Response<GitApiResponse>?) {
                val data:List<Item>? = response?.body()?.items;
            }
            override fun onFailure(call: Call<GitApiResponse>?, t: Throwable?) {
            }
        })
    }
}
