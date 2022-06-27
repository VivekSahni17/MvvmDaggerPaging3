package com.vivek.mvvmcleanarchitecture.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
//import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vivek.mvvmcleanarchitecture.databinding.ContainItemBinding
import com.vivek.mvvmcleanarchitecture.domain.model.ProductList


//class ProductListAdapter : PagingDataAdapter<ProductList, ProductListAdapter.MyViewHolder>(COMPARATOR) {
class ProductListAdapter:RecyclerView.Adapter<ProductListAdapter.MyViewHolder>() {

    var list = mutableListOf<ProductList>()

    @SuppressLint("NotifyDataSetChanged")
    fun setContentList(list: MutableList<ProductList>) {
        this.list = list
        notifyDataSetChanged()
    }
    class MyViewHolder( val viewHolder: ContainItemBinding) :
        RecyclerView.ViewHolder(viewHolder.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val binding = ContainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.viewHolder.listItem = this.list[position]
    }

    override fun getItemCount(): Int {
       return this.list.size
    }


    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ProductList>() {
            override fun areItemsTheSame(oldItem: ProductList, newItem: ProductList): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ProductList, newItem: ProductList): Boolean {
                return oldItem == newItem
            }
        }
    }
}