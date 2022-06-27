package com.vivek.mvvmcleanarchitecture.hilt

import com.vivek.mvvmcleanarchitecture.common.Cons
import com.vivek.mvvmcleanarchitecture.data.repository.ProductListRepositoryImpl
import com.vivek.mvvmcleanarchitecture.data.retrofitapi.RetrofitApi
import com.vivek.mvvmcleanarchitecture.domain.repository.ProductListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object HiltModule {

    @Provides
    @Singleton
    fun provideProductListApi():RetrofitApi{
        return Retrofit.Builder().baseUrl(Cons.BASEURL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(RetrofitApi::class.java)
    }

    @Provides
    fun provideProductListRepository(retrofitApi: RetrofitApi):ProductListRepository{
        return ProductListRepositoryImpl(retrofitApi)

    }
}