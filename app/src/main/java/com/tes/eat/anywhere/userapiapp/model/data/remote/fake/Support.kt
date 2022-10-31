package com.tes.eat.anywhere.userapiapp.model.data.remote.fake


import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("url")
    val url: String = ""
)