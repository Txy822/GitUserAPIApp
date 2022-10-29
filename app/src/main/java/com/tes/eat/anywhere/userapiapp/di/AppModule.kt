package com.tes.eat.anywhere.userapiapp.di

import com.tes.eat.anywhere.userapiapp.model.data.remote.api.UserApi
import com.tes.eat.anywhere.userapiapp.model.data.remote.api.UsersApiDetails
import com.tes.eat.anywhere.userapiapp.model.data.repository.DefaultUserRepository
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module // to define the definition of  depoendancy injection
@InstallIn(SingletonComponent::class) //to define the scope of dependancy injection
class AppModule {

    //define all the dependencies you will use
    @Provides
    //provide the retrofit instance
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(UsersApiDetails.BASE_URL)
        .build()

    @Provides
    fun providesUsersApi(retrofit: Retrofit):UserApi=retrofit.create(UserApi::class.java)

    @Provides
    fun providesRepository(
        userApi: UserApi
    ): UserRepository {
       // return DefaultUserRepository(userApi, q)
        return DefaultUserRepository(userApi)
    }

}