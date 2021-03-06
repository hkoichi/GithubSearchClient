package com.app.koichihasegawa.githubsearchclient

import android.text.Editable
import android.text.TextWatcher
import android.widget.RadioButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by koichihasegawa on 2017/07/13.
 */
class MyTextChangeListener(val activity: MainActivity,val adapter: MyListAdapter?) : TextWatcher {
    var call: Call<GitApiResponse>? = null

    override fun afterTextChanged(p0: Editable?) {
        //以前の検索が終わっていなければ終了
        call?.cancel()
        //ソートフィールドの取得
        val id = activity.radioGroup.checkedRadioButtonId
        val radioButton: RadioButton? = activity.findViewById(id) as RadioButton?
        val sortType = radioButton?.text.toString()
        //検索
        call = GitApiServiceGenerator.searchService?.search(p0.toString(),sortType, GitApiServiceGenerator.accessToken)
        call?.enqueue(object : Callback<GitApiResponse> {
            override fun onResponse(call: Call<GitApiResponse>?, response: Response<GitApiResponse>?) {
                adapter?.dataUpdate(response?.body()?.items)
            }
            override fun onFailure(call: Call<GitApiResponse>?, t: Throwable?) {
            }
        })
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }
}

