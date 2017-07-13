package com.app.koichihasegawa.githubsearchclient

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by koichihasegawa on 2017/07/13.
 */
class MyTextChangeListener(val context: Context, val service: GitApiService, val adapter: MyListAdapter) : TextWatcher {
    var call: Call<GitApiResponse>? = null

    override fun afterTextChanged(p0: Editable?) {
        //以前の検索を強制終了
        call?.cancel()
        call = service.search(p0.toString())
        call?.enqueue(object : Callback<GitApiResponse> {
            override fun onResponse(call: Call<GitApiResponse>?, response: Response<GitApiResponse>?) {
                adapter.dataUpdate(response?.body()?.items)
            }

            override fun onFailure(call: Call<GitApiResponse>?, t: Throwable?) {
                Toast.makeText(context, "api search result", Toast.LENGTH_LONG)
            }

        })
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }
}

