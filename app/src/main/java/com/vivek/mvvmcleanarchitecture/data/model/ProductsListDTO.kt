package com.vivek.mvvmcleanarchitecture.data.model

import com.google.gson.annotations.SerializedName

data class ProductsListDTO(
    @SerializedName("limit") val limit: Int?,
    @SerializedName("products") val products: List<ProductListDTO>?,
    @SerializedName("skip") val skip: Int?,
    @SerializedName("total") val total: Int?
)
