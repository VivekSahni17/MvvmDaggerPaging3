//package com.vivek.mvvmcleanarchitecture.domain.repository
//
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.liveData
//import com.vivek.mvvmcleanarchitecture.data.retrofitapi.RetrofitApi
//import com.vivek.mvvmcleanarchitecture.presentation.ProductPagingSource
//import javax.inject.Inject
//
//class ProductRepositery  @Inject constructor(private val retrofitApi: RetrofitApi) {
//
//    fun getProductList() = Pager(config = PagingConfig(pageSize = 20, maxSize = 100), pagingSourceFactory = { ProductPagingSource(retrofitApi) }).liveData
//}