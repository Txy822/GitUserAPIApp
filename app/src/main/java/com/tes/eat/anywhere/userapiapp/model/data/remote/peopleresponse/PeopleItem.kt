package com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse

import com.google.gson.annotations.SerializedName

data class PeopleItem(
    @SerializedName("avatar")
    val avatarModel: String = "",
    @SerializedName("createdAt")
    val createdAtModel: String = "",
    @SerializedName("data")
    val dataModel: PeopleData = PeopleData(),
    @SerializedName("email")
    val emailModel: String = "",
    @SerializedName("favouriteColor")
    val favouriteColorModel: String = "",
    @SerializedName("firstName")
    val firstNameModel: String = "",
    @SerializedName("fromName")
    val fromNameModel: String = "",
    @SerializedName("id")
    val idModel: String = "",
    @SerializedName("jobtitle")
    val jobtitleModel: String = "",
    @SerializedName("lastName")
    val lastNameModel: String = "",
    @SerializedName("to")
    val toModel: String = ""
)