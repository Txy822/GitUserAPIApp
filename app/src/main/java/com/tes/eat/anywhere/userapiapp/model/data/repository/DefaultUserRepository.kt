package com.tes.eat.anywhere.userapiapp.model.data.repository

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.fake.FakeApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.github.UserApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Fake
import retrofit2.Response
import javax.inject.Inject

class DefaultUserRepository @Inject constructor(
    private val userApi: UserApi,
    private val peopleApi:PeopleApi,
    private val fakeApi:FakeApi,
):UserRepository {

    override suspend fun getUsers(token:String)=userApi.getUsers(token)
    override suspend fun getPeople()= peopleApi.getPeople()
    override suspend fun getData(number: String) =fakeApi.getData(number)
    override suspend fun getSearches(name: String)=userApi.getSearches(name)


   // override suspend fun getUsers()=userApi.getUsers()
//    override suspend fun getData() =fakeApi.getData()
//    override suspend fun getSearches()=userApi.getSearches()
   // getAllUserRepos("token $VALID_TOKEN")

}