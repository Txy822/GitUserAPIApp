package com.tes.eat.anywhere.userapiapp.model.data.remote.api.fake

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApiDetails
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApiDetails.PEOPLE
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Fake
import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface FakeApi {
    @GET(FakeApiDetails.END_POINT)
    suspend fun getData(
        @Query("page") query:String
    ):Response<Fake> //call<Users>

}
