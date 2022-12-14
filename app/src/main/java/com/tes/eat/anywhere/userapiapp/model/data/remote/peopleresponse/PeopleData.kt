package com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse

import com.google.gson.annotations.SerializedName

data class PeopleData(
    @SerializedName("body")
    val bodyModel: String = "",
    @SerializedName("fromId")
    val fromIdModel: String = "",
    @SerializedName("id")
    val idModel: String = "",
    @SerializedName("meetingid")
    val meetingidModel: String = "",
    @SerializedName("title")
    val titleModel: String = "",
    @SerializedName("toId")
    val toIdModel: String = ""
)