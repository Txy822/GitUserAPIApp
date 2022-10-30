package com.tes.eat.anywhere.userapiapp.model.data.repository

import com.tes.eat.anywhere.userapiapp.model.data.remote.people.People
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.Users
import retrofit2.Response

interface UserRepository {

    suspend fun getSearches():List<User>

    suspend fun  getUsers(): List<User>

    suspend fun  getPeople(): List<PeopleItem>
}