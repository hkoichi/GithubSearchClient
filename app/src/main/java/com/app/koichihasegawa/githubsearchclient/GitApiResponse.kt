package com.app.koichihasegawa.githubsearchclient

/**
 * Created by koichihasegawa on 2017/07/11.
 * GitApiServiceから受け取ったJSONの変換後のクラス
 */

class GitApiResponse {
    private val totalCount: Int = 0
    private val incompleteResults: Boolean = true
    internal val items: List<Item>? = null
}

class Item {
    val id: Int = 0
    val name: String = ""
    val fullName: String = ""
    val owner: Owner? = null
    val private: Boolean = false
    val htmlUrl: String = ""
    val description: String = ""
    val fork: Boolean = false
    val url: String = ""
    val createdAt: String = ""
    val updatedAt: String = ""
    val pushedAt: String = ""
    val homepage: String = ""
    val size: Int = 0
    val stargazersCount: Int = 0
    val watchersCount: Int = 0
    val language: String = ""
    val forksCount: Int = 0
    val openIssuesCount: Int = 0
    val masterBranch: String = ""
    val defaultBranch: String = ""
    val score: Double = 0.0

}

class Owner {
    private val login: String = ""
    private val id: Int = 0
    private val avatarUrl: String = ""
    private val gravatarId: String = ""
    private val url: String = ""
    private val receivedEventsUrl: String = ""
    private val type: String = ""
}