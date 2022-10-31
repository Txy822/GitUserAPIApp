package com.tes.eat.anywhere.userapiapp.model.data.remote.api.github

import okhttp3.Interceptor
import okhttp3.Response

//reference: https://codersee.com/retrofit-with-kotlin-the-ultimate-guide/
object RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        println("Outgoing request to ${request.url}")
        return chain.proceed(request)
    }
}