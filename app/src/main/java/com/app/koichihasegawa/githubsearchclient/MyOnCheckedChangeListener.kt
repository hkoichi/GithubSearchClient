package com.app.koichihasegawa.githubsearchclient

import android.widget.RadioButton
import android.widget.RadioGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by koichihasegawa on 2017/07/17.
 */
class MyOnCheckedChangeListener(val activity: MainActivity,val adapter:MyListAdapter?) : RadioGroup.OnCheckedChangeListener {
    var call :Call<GitApiResponse>? = null

    override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
        //以前の検索が終わっていなければキャンセル
        call?.cancel()
        //検索文字列、ソートフィールドの取得
        val q = activity.editText.text.toString()
        val id = activity.radioGroup.checkedRadioButtonId
        val radioButton: RadioButton? = activity.findViewById(id) as RadioButton?
        val sortType = radioButton?.text.toString()
        //検索
        call = GitApiServiceGenerator.searchService?.search(q,sortType, GitApiServiceGenerator.accessToken)
        call?.enqueue(object : Callback<GitApiResponse> {
            override fun onResponse(call: Call<GitApiResponse>?, response: Response<GitApiResponse>?) {
                adapter?.dataUpdate(response?.body()?.items)
            }
            override fun onFailure(call: Call<GitApiResponse>?, t: Throwable?) {
            }
        })
    }
}