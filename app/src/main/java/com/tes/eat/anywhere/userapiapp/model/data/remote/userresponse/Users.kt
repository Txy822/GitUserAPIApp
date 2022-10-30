package com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse


import com.google.gson.annotations.SerializedName
//https://api.github.com/search/users?q=siddhant%20in:name   web
////https://api.github.com/search/users?q=tesfahun

//https://api.github.com/users    ost man
//https://api.github.com/search/users?q=siddhant in:name  postman
//https://api.github.com/users  //list of uses
// https://api.github.com/users/txy822     my detail web
/*
curl \
-H "Accept: application/vnd.github+json" \
-H "Authorization: Bearer <YOUR-TOKEN>" \
https://api.github.com/users
*/

data class Users(
    val users: List<User> = listOf()
)