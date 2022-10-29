package com.tes.eat.anywhere.userapiapp.model.data.remote.api

import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.UserList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserApi {

@GET(UsersApiDetails.Search_end) //@GET("search/users")
@Headers("Authorisation:token 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")
    fun getSearches(
        //@Query("q") query:String
        @Query("q") query:String ="tesfahun"
        ):Response<UserList> //call<UserList>


    @GET(UsersApiDetails.User_end) //@GET("users")
    @Headers("Authorisation:token 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")
    fun getUsers(
    ):Response<UserList> //call<UserList>
}