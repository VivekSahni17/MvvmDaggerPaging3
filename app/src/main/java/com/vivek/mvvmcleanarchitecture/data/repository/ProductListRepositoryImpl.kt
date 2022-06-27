package com.vivek.mvvmcleanarchitecture.data.repository

import com.vivek.mvvmcleanarchitecture.data.model.ProductsListDTO
import com.vivek.mvvmcleanarchitecture.data.retrofitapi.RetrofitApi
import com.vivek.mvvmcleanarchitecture.domain.repository.ProductListRepository

class ProductListRepositoryImpl(private val retrofitApi: RetrofitApi):ProductListRepository {
    override suspend fun getProductList(page: String): ProductsListDTO {
        return retrofitApi.getProductList(page)
    }
}