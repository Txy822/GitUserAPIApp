package com.tes.eat.anywhere.userapiapp.model.data.remote.responses


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String = "",
    @SerializedName("bio")
    val bio: String = "",
    @SerializedName("blog")
    val blog: String = "",
    @SerializedName("collaborators")
    val collaborators: Int = 0,
    @SerializedName("company")
    val company: String = "",
    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("disk_usage")
    val diskUsage: Int = 0,
    @SerializedName("email")
    val email: String = "",
    @SerializedName("events_url")
    val eventsUrl: String = "",
    @SerializedName("followers")
    val followers: Int = 0,
    @SerializedName("followers_url")
    val followersUrl: String = "",
    @SerializedName("following")
    val following: Int = 0,
    @SerializedName("following_url")
    val followingUrl: String = "",
    @SerializedName("gists_url")
    val gistsUrl: String = "",
    @SerializedName("gravatar_id")
    val gravatarId: String = "",
    @SerializedName("hireable")
    val hireable: Boolean = false,
    @SerializedName("html_url")
    val htmlUrl: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("location")
    val location: String = "",
    @SerializedName("login")
    val login: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("node_id")
    val nodeId: String = "",
    @SerializedName("organizations_url")
    val organizationsUrl: String = "",
    @SerializedName("owned_private_repos")
    val ownedPrivateRepos: Int = 0,
    @SerializedName("plan")
    val plan: Plan = Plan(),
    @SerializedName("private_gists")
    val privateGists: Int = 0,
    @SerializedName("public_gists")
    val publicGists: Int = 0,
    @SerializedName("public_repos")
    val publicRepos: Int = 0,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String = "",
    @SerializedName("repos_url")
    val reposUrl: String = "",
    @SerializedName("site_admin")
    val siteAdmin: Boolean = false,
    @SerializedName("starred_url")
    val starredUrl: String = "",
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String = "",
    @SerializedName("total_private_repos")
    val totalPrivateRepos: Int = 0,
    @SerializedName("twitter_username")
    val twitterUsername: String = "",
    @SerializedName("two_factor_authentication")
    val twoFactorAuthentication: Boolean = false,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("updated_at")
    val updatedAt: String = "",
    @SerializedName("url")
    val url: String = ""
)