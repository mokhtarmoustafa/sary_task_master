package com.mokhtar.sarytask.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.mokhtar.sarytask.databinding.FragmentHomeBinding
import com.mokhtar.sarytask.ui.home.banner.BannerAdapter
import com.mokhtar.sarytask.ui.home.adapter.custom.catalog.CatalogAdapter
import com.mokhtar.sarytask.util.ConnectionLiveData
import com.mokhtar.sarytask.util.NetworkWrapper
import com.mokhtar.sarytask.util.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {


    //region variables
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private val adapter = BannerAdapter()
    private  val catalogAdapter= CatalogAdapter()
    private lateinit var connectionLiveData: ConnectionLiveData
    //endregion


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        init("en")
        observeData()




        return binding.root
    }





    //endregion

    //region helper functions

    private fun init(language: String) {

        binding.bannerAdapter = adapter
        binding.catalogAdapter=catalogAdapter

        connectionLiveData = ConnectionLiveData(requireContext())
        connectionLiveData.observe(viewLifecycleOwner) { isNetworkAvailable ->
            Log.d(TAG, "init: $isNetworkAvailable")
            isNetworkAvailable?.let {valid->
               if(valid)
               {
                   viewModel.getCatalogs(language)
                   viewModel.getBanners(language)
               }
            }
        }


    }

    private fun observeData() {

        viewModel.bannerData.observe(viewLifecycleOwner, Observer { result ->

            when (result) {
                is NetworkWrapper.Loading -> {
                    binding.progressBarBanner.isVisible = true
                }
                is NetworkWrapper.Error -> {
                    binding.progressBarBanner.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        "Error Occur: ${result.errorMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkWrapper.Success -> {
                    binding.progressBarBanner.isVisible = false
                    adapter.setBannerData(result.data)
                }


            }
        })



        viewModel.catalogResult.observe(viewLifecycleOwner, Observer { result ->

            when (result) {
                is NetworkWrapper.Loading -> {
                    binding.progressBarBanner.isVisible = true
                }

                is NetworkWrapper.Error -> {
                    binding.progressBarBanner.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        "Error Occur: ${result.errorMessage}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                is NetworkWrapper.Success -> {
                    binding.progressBarBanner.isVisible = false
                    catalogAdapter.submitList((result.data ))
                }


            }
        })
    }
    //endregion

    companion object {
        private const val TAG = "HomeFragment"
    }


}