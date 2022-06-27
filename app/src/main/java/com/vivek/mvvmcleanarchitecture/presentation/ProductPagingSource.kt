package com.vivek.mvvmcleanarchitecture.presentation

import androidx.paging.PagingSource
import androidx.paging.PagingState

import com.vivek.mvvmcleanarchitecture.data.retrofitapi.RetrofitApi
import com.vivek.mvvmcleanarchitecture.domain.model.ProductList
import com.vivek.mvvmcleanarchitecture.domain.repository.ProductListRepository

import java.lang.Exception

class ProductPagingSource(private val retrofitApi: RetrofitApi):PagingSource<Int, ProductList>() {

    //private var response:ProductListRepository?=null
    override fun getRefreshKey(state: PagingState<Int, ProductList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductList> {
        return try {
            val position = params.key ?: 1
            val response= retrofitApi.getProductList(position.toString())






            return LoadResult.Page(
                data = response.products,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (position == response.total) null else position + 1)

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}

