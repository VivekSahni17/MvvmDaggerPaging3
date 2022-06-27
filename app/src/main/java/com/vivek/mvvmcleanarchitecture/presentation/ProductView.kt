//package com.vivek.mvvmcleanarchitecture.presentation
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.paging.cachedIn
//import com.vivek.mvvmcleanarchitecture.domain.repository.ProductRepositery
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//@HiltViewModel
//class ProductView @Inject constructor(private val repositery: ProductRepositery): ViewModel() {
//    val list = repositery.getProductList().cachedIn(viewModelScope)
//}