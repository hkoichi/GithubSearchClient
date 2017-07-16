package com.app.koichihasegawa.githubsearchclient

import retrofit2.Call
import retrofit2.http.*


/**
 * Created by koichihasegawa on 2017/07/11.
 * GitApiServiceを実行するためのinterface
 */
interface GitApiService {
    @GET("/search/repositories")
    fun search(@Query("q") q: String?,
               @Query("sort") sortType: String?,
               @Query("access_token") accessToken: String?
    ): Call<GitApiResponse>
}

interface GitOauthService {
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("/login/oauth/access_token")
    fun getAccessToken(
            @Field("code") code: String
    ): Call<AccessToken>
}
