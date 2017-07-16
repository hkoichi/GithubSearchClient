package com.app.koichihasegawa.githubsearchclient

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.RadioGroup
import kotterknife.bindView


class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val editText: EditText by bindView(R.id.editText)
    val radioGroup: RadioGroup by bindView(R.id.radioGroup)

    var adapter: MyListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerViewの設定
        adapter = MyListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        //APIサービスの初期化
        GitApiServiceGenerator.searchService = GitApiServiceGenerator.createApiService()

        //editText,radioGroupの設定
        //MyTextChangeListenerクラスではテキストの更新毎にadapterのデータの更新を行う
        val mTextChangeListener = MyTextChangeListener(this,adapter)
        editText.addTextChangedListener(mTextChangeListener)
        //検索ボタンを押したときにkeyboardを隠すための設定
        editText.setOnFocusChangeListener { view, b ->
            if(b==false) {
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS)
            }
        }
        //MyOnChangeListenerクラスではソートフィールドの更新毎にadapterのデータの更新を行う
        val mOnCheckedChangeListener = MyOnCheckedChangeListener(this,adapter)
        radioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener)
        radioGroup.check(R.id.stars)
    }
}