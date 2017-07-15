package com.app.koichihasegawa.githubsearchclient

import com.google.gson.annotations.SerializedName

/**
 * Created by koichihasegawa on 2017/07/15.
 */
class AccessToken {
    @SerializedName("access_token")
    var access_token: String? = null
    @SerializedName("token_type")
    private var token_type: String? = null
}