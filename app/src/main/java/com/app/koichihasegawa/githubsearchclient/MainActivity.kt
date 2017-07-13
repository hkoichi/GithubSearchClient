package com.app.koichihasegawa.githubsearchclient

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import kotterknife.bindView

class MainActivity : AppCompatActivity() {
    val recyclerView: RecyclerView by bindView(R.id.recyclerView)
    val editText: EditText by bindView(R.id.editText)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //アダプター、apiサービス、テキストチェンジリスナーの初期化
        val adapter = MyListAdapter(this)
        val service = GitApiServiceGenerator.createService()
        //MyTextChangeListenerクラスではGitApiServiceの実行、adapterへのデータの追加を行う
        val mTextChangeListener = MyTextChangeListener(this, service, adapter)

        //recyclerViewへの紐付け
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        //editTextへのテキストチェンジリスナーの紐付け
        editText.addTextChangedListener(mTextChangeListener)
    }
}