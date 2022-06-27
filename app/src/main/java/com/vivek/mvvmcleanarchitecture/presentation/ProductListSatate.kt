package com.vivek.mvvmcleanarchitecture.presentation

import com.vivek.mvvmcleanarchitecture.domain.model.ProductList

data class ProductListState(
val isLoading:Boolean = false,
val data:List<ProductList>?=null,
val error:String = ""
)
