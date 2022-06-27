package com.vivek.mvvmcleanarchitecture.domain.use_cases

import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.load.HttpException
import com.vivek.mvvmcleanarchitecture.common.NetworkResult
import com.vivek.mvvmcleanarchitecture.data.model.toDomainProductList
import com.vivek.mvvmcleanarchitecture.domain.model.ProductList
import com.vivek.mvvmcleanarchitecture.domain.repository.ProductListRepository
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.util.concurrent.Flow
import javax.inject.Inject

class ProductListUseCase @Inject constructor(private val repository: ProductListRepository) {
    operator fun invoke(q: String): kotlinx.coroutines.flow.Flow<NetworkResult<List<ProductList>>> = flow {
    try {
        emit(NetworkResult.Loading())
        val data = repository.getProductList(q)
        val domainData =
            if (data.products!=null) data.products.map { it->it.toDomainProductList() } else emptyList()
          emit(NetworkResult.Success(data = domainData))
    }catch (e:HttpException){
        emit(NetworkResult.Error(message = e.localizedMessage ?: "An Unknown Error Occurred"))
    } catch (e:IOException){
        emit(NetworkResult.Error(message = "Check Internet Connectivity"))
    }


    }
}