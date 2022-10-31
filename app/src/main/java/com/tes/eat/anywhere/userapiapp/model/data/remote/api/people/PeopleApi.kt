package com.tes.eat.anywhere.userapiapp.model.data.remote.api.people

import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem
import retrofit2.http.GET

interface PeopleApi {//we do not have to any implementation

    @GET(PeopleApiDetails.PEOPLE) //to define type of request GET, POST, PUT
     fun getPeople(): List<PeopleItem>
}