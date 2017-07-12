package com.app.koichihasegawa.githubsearchclient

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotterknife.bindView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service = GitApiServiceGenerator.createService()
        val call = service.search("kotlin")
        call.enqueue(object : retrofit2.Callback<GitApiResponse> {
            override fun onResponse(call: Call<GitApiResponse>?, response: Response<GitApiResponse>?) {
                val data: List<Item>? = response?.body()?.items;
                val adapter = data?.let {
                    MyListAdapter(this@MainActivity,data){
                        urlString ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(urlString))
                        startActivity(intent)
                    }
                }
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<GitApiResponse>?, t: Throwable?) {
            }
        })
    }
}
