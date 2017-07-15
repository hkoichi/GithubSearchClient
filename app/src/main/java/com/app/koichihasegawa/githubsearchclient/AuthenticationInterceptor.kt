package com.app.koichihasegawa.githubsearchclient

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by koichihasegawa on 2017/07/15.
 */
class AuthenticationInterceptor(val token:String) :Interceptor{
    override fun intercept(chain: Interceptor.Chain?): Response {
        val original = chain!!.request()

        val builder = original.newBuilder().header("Authorization", token)

        val request = builder.build()
        return chain!!.proceed(request)
    }

}