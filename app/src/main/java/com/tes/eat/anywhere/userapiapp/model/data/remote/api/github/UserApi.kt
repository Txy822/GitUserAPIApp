package com.tes.eat.anywhere.userapiapp.model.data.remote.api.github

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApiDetails
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApiDetails.PEOPLE
import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserApi {

@GET(UsersApiDetails.Search_end)
@Headers("Authorization:token your token key")
   suspend  fun getSearches(
        @Query("q") query:String
        ):List<User> //call<Users>

    @GET(UsersApiDetails.User_end)
    suspend fun getUsers(
        @Header("Authorization") accessToken: String
    ):List<User>

}