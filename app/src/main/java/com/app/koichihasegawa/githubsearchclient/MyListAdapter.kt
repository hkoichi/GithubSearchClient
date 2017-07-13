package com.app.koichihasegawa.githubsearchclient

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotterknife.bindView

/**
 * Created by koichihasegawa on 2017/07/13.
 */
class MyListAdapter(val context: Context) : RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {
    //検索したデータはアダプターが保持する
    var data: List<Item>? = null

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.setUp(data?.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_sub, parent, false), context)
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return data!!.size
        } else {
            return 0
        }
    }

    fun dataUpdate(addData: List<Item>?) {
        data = addData
        this.notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?, val context: Context) : RecyclerView.ViewHolder(itemView) {
        val title: TextView by bindView(R.id.title)
        val desctiprion: TextView by bindView(R.id.description)
        val stars: TextView by bindView(R.id.stars)
        val language: TextView by bindView(R.id.language)

        fun setUp(item: Item?) {
            this.title.text = item?.name
            this.desctiprion.text = item?.description
            this.language.text = item?.language
            this.stars.text = item?.score.toString()
            this.itemView.setOnClickListener {
                val intent: Intent = Intent(Intent.ACTION_VIEW, Uri.parse(item?.htmlUrl))
                startActivity(context, intent, null)
            }
        }
    }
}