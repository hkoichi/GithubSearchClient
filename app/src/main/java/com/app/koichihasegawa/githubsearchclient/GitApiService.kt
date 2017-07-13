package com.app.koichihasegawa.githubsearchclient

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by koichihasegawa on 2017/07/11.
 * GitApiServiceを実行するためのクラス
 */
interface GitApiService {
    @GET("/search/repositories")
    fun search(@Query("q") q: String): Call<GitApiResponse>
}