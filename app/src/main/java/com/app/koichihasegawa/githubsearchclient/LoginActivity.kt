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

        val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse(GitApiServiceGenerator.OAUTH_BASE_URL + "/login/oauth/authorize" + "?client_id=" + clientId + "&redirect_uri=" + redirectUri))
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val uri = intent.data
        if (uri != null) {
            val code = uri.getQueryParameter("code")
            if (code != null) {
                val service = GitApiServiceGenerator.createOauthService(clientId, clientSecret)
                val call = service.getAccessToken(code)
                call.enqueue(object : Callback<AccessToken> {
                    override fun onFailure(call: Call<AccessToken>?, t: Throwable?) {
                        Toast.makeText(this@LoginActivity, "failure", Toast.LENGTH_LONG).show()
                    }
                    override fun onResponse(call: Call<AccessToken>?, response: Response<AccessToken>?) {
                        val accessToken = response?.body()
                        val intent = Intent(this@LoginActivity, MainActivity::class.java)
                        intent.putExtra("accessToken",accessToken?.access_token)
                        startActivity(intent)
                    }
                })
            } else if (uri.getQueryParameter("error") != null) {
            }
        }
    }

}
