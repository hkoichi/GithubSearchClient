package com.app.koichihasegawa.githubsearchclient

/**
 * Created by koichihasegawa on 2017/07/11.
 */

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GitApiResponse {

    @SerializedName("total_count")
    @Expose
    private val totalCount: Int = 0
    @SerializedName("incomplete_results")
    @Expose
    private val incompleteResults: Boolean = true
    @SerializedName("items")
    @Expose
    internal val items: List<Item>? = null

}

class Item {

    @SerializedName("id")
    @Expose
     val id: Int = 0
    @SerializedName("name")
    @Expose val name: String = ""
    @SerializedName("full_name")
    @Expose
     val fullName: String = ""
    @SerializedName("owner")
    @Expose
     val owner: Owner? = null
    @SerializedName("")
    @Expose
     val private: Boolean = false
    @SerializedName("html_url")
    @Expose
     val htmlUrl: String = ""
    @SerializedName("description")
    @Expose
     val description: String = ""
    @SerializedName("fork")
    @Expose
     val fork: Boolean = false
    @SerializedName("url")
    @Expose
     val url: String = ""
    @SerializedName("created_at")
    @Expose
     val createdAt: String = ""
    @SerializedName("updated_at")
    @Expose
     val updatedAt: String = ""
    @SerializedName("pushed_at")
    @Expose
     val pushedAt: String = ""
    @SerializedName("homepage")
    @Expose
     val homepage: String = ""
    @SerializedName("size")
    @Expose
     val size: Int = 0
    @SerializedName("stargazers_count")
    @Expose
     val stargazersCount: Int = 0
    @SerializedName("watchers_count")
    @Expose
     val watchersCount: Int = 0
    @SerializedName("language")
    @Expose
     val language: String = ""
    @SerializedName("forks_count")
    @Expose
     val forksCount: Int = 0
    @SerializedName("open_issues_count")
    @Expose
     val openIssuesCount: Int = 0
    @SerializedName("master_branch")
    @Expose
     val masterBranch: String = ""
    @SerializedName("default_branch")
    @Expose
     val defaultBranch: String = ""
    @SerializedName("score")
    @Expose
     val score: Double = 0.0

}

class Owner {

    @SerializedName("login")
    @Expose
    private val login: String = ""
    @SerializedName("id")
    @Expose
    private val id: Int = 0
    @SerializedName("avatar_url")
    @Expose
    private val avatarUrl: String = ""
    @SerializedName("gravatar_id")
    @Expose
    private val gravatarId: String = ""
    @SerializedName("url")
    @Expose
    private val url: String = ""
    @SerializedName("received_events_url")
    @Expose
    private val receivedEventsUrl: String = ""
    @SerializedName("type")
    @Expose
    private val type: String = ""

}