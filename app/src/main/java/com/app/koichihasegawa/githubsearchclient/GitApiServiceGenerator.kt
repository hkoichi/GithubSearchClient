package com.app.koichihasegawa.githubsearchclient

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by koichihasegawa on 2017/07/11.
 */
class GitApiServiceGenerator {
    companion object {
        fun createService(): GitApiService {
            val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
            val apiUrl = "https://api.github.com/"
            val retrofit = Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            return retrofit.create(GitApiService::class.java)
        }
    }
}