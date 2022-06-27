package com.vivek.mvvmcleanarchitecture.data.retrofitapi

import com.vivek.mvvmcleanarchitecture.data.model.ProductListDTO
import com.vivek.mvvmcleanarchitecture.data.model.ProductsListDTO
import com.vivek.mvvmcleanarchitecture.domain.model.ProductList
import com.vivek.mvvmcleanarchitecture.presentation.ProductListState
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApi {

    @GET("products")
    suspend fun getProductList(@Query("page") page:String): ProductsListDTO
}