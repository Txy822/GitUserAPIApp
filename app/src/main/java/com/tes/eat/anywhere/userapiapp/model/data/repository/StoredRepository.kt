package com.tes.eat.anywhere.userapiapp.model.data.repository


import android.content.Context
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import getJsonDataFromAsset
import javax.inject.Inject

class StoredRepository @Inject constructor(private val context: Context) {

    fun getUsers(): ArrayList<User>? {
        val jsonFileString = context.getJsonDataFromAsset("users.json") ?: return null
        val moshi: Moshi = Moshi.Builder().addLast(jsonFileString ).build()
        val userList = Types.newParameterizedType(List::class.java, User::class.java)
        val jsonAdapter: JsonAdapter<ArrayList<User>> = moshi.adapter(userList)
        return jsonAdapter.fromJson(jsonFileString)
    }
    fun getUser(id: Int?): User? {
        val users = getUsers()
        return users?.find { x -> x.id == id }
    }
}