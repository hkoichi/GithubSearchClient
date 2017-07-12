package com.app.koichihasegawa.githubsearchclient

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotterknife.bindView

/**
 * Created by koichihasegawa on 2017/07/13.
 */
class MyListAdapter(context: Context, val data:List<Item>,val onItemClick: (String) -> Unit) : RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {
    val layoutInflator = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.setUp(data.get(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        return MyViewHolder(layoutInflator.inflate(R.layout.list_sub, parent, false), onItemClick)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    class MyViewHolder(itemView: View?,val onItemClick: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val title: TextView by bindView(R.id.title)
        val desctiprion: TextView by bindView(R.id.description)
        val stars: TextView by bindView(R.id.stars)
        val language: TextView by bindView(R.id.language)

        fun setUp(item: Item) {
            this.title.text = item.name
            this.desctiprion.text = item.description
            this.language.text = item.language
            this.stars.text = item.score.toString()
            this.itemView.setOnClickListener { onItemClick(item.htmlUrl) }
        }
    }
}