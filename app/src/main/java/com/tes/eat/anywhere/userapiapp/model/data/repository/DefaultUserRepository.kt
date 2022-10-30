package com.tes.eat.anywhere.userapiapp.model.data.repository

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.UserApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.People
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val userApi:UserApi
//    private val q:String
):UserRepository {
    override suspend fun getSearches() =userApi.getUsers()
    //override suspend fun getSearches() =userApi.getSearches(q)

   override suspend fun getUsers()=userApi.getUsers()

    override suspend fun getPeople()=userApi.getPeople()
}