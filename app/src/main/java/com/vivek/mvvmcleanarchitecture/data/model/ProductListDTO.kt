package com.vivek.mvvmcleanarchitecture.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.vivek.mvvmcleanarchitecture.domain.model.ProductList
import com.vivek.mvvmcleanarchitecture.domain.model.ProductListDetails

@Keep
data class ProductListDTO(
    @SerializedName("brand") val brand: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("discountPercentage") val discountPercentage: Double?,
    @SerializedName("id") val id: String,
    @SerializedName("images") val images: List<String?>?,
    @SerializedName("price") val price: Int?,
    @SerializedName("rating") val rating: Double?,
    @SerializedName("stock") val stock: Int?,
    @SerializedName("thumbnail") val thumbnail: String?,
    @SerializedName("title") val title: String?
    )

data class ProductsListDTO2(
    @SerializedName("limit") val limit: Int?,
    @SerializedName("products") val products: List<ProductListDTO>?,
    @SerializedName("skip") val skip: Int?,
    @SerializedName("total") val total: Int?)

fun ProductListDTO.toDomainProductList():ProductList{
return ProductList(
    id = this.id,
    brand = this.brand?:"",
    thumbnail = this.thumbnail?:"")

}

fun ProductListDTO.toDomainDTO():ProductListDetails{
    return ProductListDetails(
     brand =this.brand?:"",
        thumbnail=this.thumbnail?:""

    )
}