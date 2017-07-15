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

    var adapter: MyListAdapter? = null
    var service: GitApiService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //アダプター、apiサービス、テキストチェンジリスナーの初期化
        val adapter = MyListAdapter(this)
        val accessToken = intent.getStringExtra("accessToken")
        service = GitApiServiceGenerator.createApiService()

        //MyTextChangeListenerクラスではGitApiServiceの実行、adapterへのデータの追加を行う
        val mTextChangeListener = MyTextChangeListener(this, service!!, adapter,accessToken)

        //recyclerViewへの紐付け
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        //editTextへのテキストチェンジリスナーの紐付け
        editText.addTextChangedListener(mTextChangeListener)
    }
}