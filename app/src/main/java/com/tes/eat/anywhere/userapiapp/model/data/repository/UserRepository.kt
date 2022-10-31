package com.tes.eat.anywhere.userapiapp.model.data.repository

import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Fake
import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import retrofit2.Response
import retrofit2.http.Query

interface UserRepository {

    suspend fun  getUsers(token:String): List<User>

    suspend fun  getPeople(): List<PeopleItem>

    suspend fun  getData(@Query("page") number: String): Response<Fake>
    suspend fun getSearches(@Query("q") name: String):List<User>
  //  suspend fun  getUsers(): List<User>
//    suspend fun  getData(): Response<Fake>
//    suspend fun getSearches():List<User>



}