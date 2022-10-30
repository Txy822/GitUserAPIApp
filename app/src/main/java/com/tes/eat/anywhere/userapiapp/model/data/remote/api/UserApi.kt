package com.tes.eat.anywhere.userapiapp.model.data.remote.api

import androidx.compose.ui.input.key.Key.Companion.H
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.People
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.Users
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserApi {

@GET(UsersApiDetails.Search_end) //@GET("search/users")
@Headers("Authorisation:token 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")
    fun getSearches(
        //@Query("q") query:String
        @Query("q") query:String ="tesfahun"
        ):List<User> //call<Users>


    @GET(UsersApiDetails.User_end) //@GET("users")

    @Headers("Accept: application/vnd.github+json")
    fun getUsers(
    ):List<User> //call<Users>


    @GET(UsersApiDetails.PEOPLE) //to define type of request GET, POST, PUT
    suspend fun getPeople(): List<PeopleItem>

}