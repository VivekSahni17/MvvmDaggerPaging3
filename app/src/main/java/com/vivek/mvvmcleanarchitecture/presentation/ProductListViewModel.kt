package com.vivek.mvvmcleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.mvvmcleanarchitecture.common.NetworkResult
import com.vivek.mvvmcleanarchitecture.domain.use_cases.ProductListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productListUseCase: ProductListUseCase):ViewModel(){
private val _productList = MutableStateFlow<ProductListState>(ProductListState())
    val productList:StateFlow<ProductListState> = _productList

    fun getProductList(page:String){
     productListUseCase(page).onEach {
      when(it){
         is NetworkResult.Loading ->{
           _productList.value = ProductListState(isLoading = true)
         }
          is NetworkResult.Success->{
              _productList.value = ProductListState(data = it.data)
          }
          is NetworkResult.Error->{
              _productList.value = ProductListState(error = it.message ?: "")
          }

      }
     }.launchIn(viewModelScope)
    }
}