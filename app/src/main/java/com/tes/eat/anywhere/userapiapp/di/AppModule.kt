package com.tes.eat.anywhere.userapiapp.di

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.fake.FakeApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.fake.FakeApiDetails
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.github.RequestInterceptor
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.github.UserApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.github.UsersApiDetails
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.people.PeopleApiDetails
import com.tes.eat.anywhere.userapiapp.model.data.repository.DefaultUserRepository
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // to define the definition of  depoendancy injection
@InstallIn(SingletonComponent::class) //to define the scope of dependancy injection
class AppModule {
    val okHttpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        })
        .build()

    //define all the dependencies you will use
    @Provides
    //provide the retrofit instance
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        //.client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
//        .baseUrl(UsersApiDetails.BASE_URL)
        .baseUrl(UsersApiDetails.BASE_URL)
        .build()

    @Provides
    fun providesUsersApi(retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)

    @Provides
    fun providesPeopleApi(retrofit: Retrofit): PeopleApi = retrofit.newBuilder()
        //.client(okHttpClient)
        .baseUrl(PeopleApiDetails.BASE_URL)
        .build().create(PeopleApi::class.java)

    @Provides
    fun providesFakeApi(retrofit: Retrofit): FakeApi = retrofit.newBuilder()
        .client(okHttpClient)
        .baseUrl(FakeApiDetails.BASE_URL)
        .build().create(FakeApi::class.java)


    @Provides
    fun providesRepository(
        userApi: UserApi,
        peopleApi: PeopleApi,
        fakeApi: FakeApi,
    ): UserRepository {
        return DefaultUserRepository(userApi, peopleApi, fakeApi)
    }

    /*
    object RetrofitClient {

    fun getInstance(): Retrofit {
        var mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        var mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()


        var retrofit: Retrofit = retrofit2.Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        return retrofit
    }

}
     */

}