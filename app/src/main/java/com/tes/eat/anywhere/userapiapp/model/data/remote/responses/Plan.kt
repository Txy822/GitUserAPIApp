package com.tes.eat.anywhere.userapiapp.model.data.remote.responses


import com.google.gson.annotations.SerializedName

data class Plan(
    @SerializedName("collaborators")
    val collaborators: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("private_repos")
    val privateRepos: Int = 0,
    @SerializedName("space")
    val space: Int = 0
)