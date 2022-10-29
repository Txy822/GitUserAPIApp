package com.tes.eat.anywhere.userapiapp.model.data.repository

import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.UserList
import retrofit2.Response

interface UserRepository {

    suspend fun getSearches():Response<UserList>

    suspend fun  getUsers(): Response<UserList>
}