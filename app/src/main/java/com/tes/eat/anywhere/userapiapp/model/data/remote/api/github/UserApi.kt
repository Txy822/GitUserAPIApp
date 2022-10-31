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

@GET(UsersApiDetails.Search_end) //@GET("search/users")
@Headers("Authorization:token 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")
   suspend  fun getSearches(
        //@Query("q") query:String
        @Query("q") query:String
        ):List<User> //call<Users>


    @GET(UsersApiDetails.User_end) //@GET("users")
    @Headers("Authorization:token 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")
   suspend fun getUsers2(
    ):List<User> //call<Users>

    @GET(UsersApiDetails.User_end) //@GET("users")
    suspend fun getUsers(
        @Header("Authorization") accessToken: String
    ):List<User> //call<Users>

}