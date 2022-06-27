package com.vivek.mvvmcleanarchitecture.domain.repository

import com.vivek.mvvmcleanarchitecture.data.model.ProductsListDTO

interface ProductListRepository {

    suspend fun getProductList(page:String):ProductsListDTO
}

