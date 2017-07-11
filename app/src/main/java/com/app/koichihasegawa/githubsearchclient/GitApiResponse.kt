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

internal class Item {

    @SerializedName("id")
    @Expose
    private val id: Int = 0
    @SerializedName("name")
    @Expose
    private val name: String = ""
    @SerializedName("full_name")
    @Expose
    private val fullName: String = ""
    @SerializedName("owner")
    @Expose
    private val owner: Owner? = null
    @SerializedName("private")
    @Expose
    private val private: Boolean = false
    @SerializedName("html_url")
    @Expose
    private val htmlUrl: String = ""
    @SerializedName("description")
    @Expose
    private val description: String = ""
    @SerializedName("fork")
    @Expose
    private val fork: Boolean = false
    @SerializedName("url")
    @Expose
    private val url: String = ""
    @SerializedName("created_at")
    @Expose
    private val createdAt: String = ""
    @SerializedName("updated_at")
    @Expose
    private val updatedAt: String = ""
    @SerializedName("pushed_at")
    @Expose
    private val pushedAt: String = ""
    @SerializedName("homepage")
    @Expose
    private val homepage: String = ""
    @SerializedName("size")
    @Expose
    private val size: Int = 0
    @SerializedName("stargazers_count")
    @Expose
    private val stargazersCount: Int = 0
    @SerializedName("watchers_count")
    @Expose
    private val watchersCount: Int = 0
    @SerializedName("language")
    @Expose
    private val language: String = ""
    @SerializedName("forks_count")
    @Expose
    private val forksCount: Int = 0
    @SerializedName("open_issues_count")
    @Expose
    private val openIssuesCount: Int = 0
    @SerializedName("master_branch")
    @Expose
    private val masterBranch: String = ""
    @SerializedName("default_branch")
    @Expose
    private val defaultBranch: String = ""
    @SerializedName("score")
    @Expose
    private val score: Double = 0.0

}

internal class Owner {

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