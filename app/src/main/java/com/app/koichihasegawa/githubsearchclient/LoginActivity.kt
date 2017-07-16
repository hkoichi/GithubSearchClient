package com.app.koichihasegawa.githubsearchclient

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginActivity : AppCompatActivity() {
    private val clientId = "b96ff3bd9171ec4d2a54"
    private val clientSecret = "0114e47009e740d3600388bcab2b4ed2e5c2426b"
    private val redirectUri = "hase://app"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //oauthServiceの初期化
        GitApiServiceGenerator.oauthService = GitApiServiceGenerator.createOauthService(clientId, clientSecret)
        //アクセスコードの取得のためのintent
        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(GitApiServiceGenerator.OAUTH_BASE_URL + "/login/oauth/authorize" + "?client_id=" + clientId + "&redirect_uri=" + redirectUri + "&scope=public_repo"))
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()
        //アクセスコードを取得し、アクセストークンを取得
        val uri = intent.data
        if (uri != null && uri.toString().startsWith(redirectUri)) {
            val code = uri.getQueryParameter("code")
            if (code != null) {
                val call = GitApiServiceGenerator.oauthService?.getAccessToken(code)
                call?.enqueue(object : Callback<AccessToken> {
                    override fun onFailure(call: Call<AccessToken>?, t: Throwable?) {
                        Toast.makeText(this@LoginActivity, "authentication failure", Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<AccessToken>?, response: Response<AccessToken>?) {
                        if (response?.body()?.access_token == null) {
                            return
                        } else {
                            Toast.makeText(this@LoginActivity, "authentication success", Toast.LENGTH_SHORT).show()
                            //accessTokenの設定
                            GitApiServiceGenerator.accessToken = response?.body()?.access_token
                        }
                    }
                })
                //MainAcitivityへのintent
                var intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
