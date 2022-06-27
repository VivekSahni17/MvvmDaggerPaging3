package com.vivek.mvvmcleanarchitecture.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import com.vivek.mvvmcleanarchitecture.R
import com.vivek.mvvmcleanarchitecture.databinding.FragmentAllProductsBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.Collections.list


@AndroidEntryPoint
class AllProductsFragment : Fragment() {
lateinit var mBinding:FragmentAllProductsBinding
//lateinit var productView:ProductView

private val productAdapter = ProductListAdapter()

private val viewModel:ProductListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_all_products, container, false)
        mBinding = FragmentAllProductsBinding.bind(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //productView = ViewModelProvider(this)[ProductView::class.java]

       mBinding.productListRecy.apply {
           adapter = productAdapter

       }

        viewModel.getProductList(page = "")

        lifecycle.coroutineScope.launchWhenCreated {
         viewModel.productList.collect{ it ->
             if (it.isLoading) {
//                 binding.nothingFound.visibility = View.GONE
//                 binding.progressMealSearch.visibility = View.VISIBLE
             }
             if (it.error.isNotBlank()) {
//                 binding.nothingFound.visibility = View.GONE
//                 binding.progressMealSearch.visibility = View.GONE
                 Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
             }

             it.data?.let {

                 if (it.isEmpty()) {
                     //binding.nothingFound.visibility = View.VISIBLE
                 }
                 //binding.progressMealSearch.visibility = View.GONE
                 productAdapter.setContentList(it.toMutableList())
             }

         }
        }

//        productView.list.observe(requireActivity(), Observer {
//            productAdapter.submitData(lifecycle, it)
//        })
    }



}