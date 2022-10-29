package com.tes.eat.anywhere.userapiapp.model.data.repository

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.UserApi
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val userApi:UserApi
//    private val q:String
):UserRepository {
    override suspend fun getSearches() =userApi.getSearches()
    //override suspend fun getSearches() =userApi.getSearches(q)

    override suspend fun getUsers()=userApi.getUsers()
}