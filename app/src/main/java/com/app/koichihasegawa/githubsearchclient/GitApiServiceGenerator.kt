package com.app.koichihasegawa.githubsearchclient

import com.google.gson.GsonBuilder
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by koichihasegawa on 2017/07/11.
 * GitApiServiceのインスタンス生成用のクラス
 */
class GitApiServiceGenerator {
    companion object {
        private val httpClient = OkHttpClient.Builder()
        private val gson = GsonBuilder().create()
        private val API_BASE_URL = "https://api.github.com/"
        val OAUTH_BASE_URL = "https://github.com/"


        //githubのAPIとoauth認証はurlが異なるためそれぞれserviceGeneratorを設定する
        var oauthService: GitOauthService? = null
        var searchService: GitApiService? = null

        var accessToken: String? = null

        private var clientId: String? = null
        private var clientSecret: String? = null

        private val builderApi = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
        private val builderOauth = Retrofit.Builder()
                .baseUrl(OAUTH_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))

        fun createApiService(): GitApiService {
            return builderApi.build().create(GitApiService::class.java)
        }

        fun createOauthService(clientId: String, clientSecret: String): GitOauthService {
            this.clientId = clientId
            this.clientSecret = clientSecret
            val oauthToken = Credentials.basic(clientId, clientSecret)
            val intercepter = AuthenticationInterceptor(oauthToken)
            httpClient.addInterceptor(intercepter)
            builderOauth.client(httpClient.build())
            return builderOauth.build().create(GitOauthService::class.java)
        }
    }
}

