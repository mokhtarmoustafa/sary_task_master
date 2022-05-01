package com.mokhtar.sarytask.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.mokhtar.sarytask.data.model.banner.Banner
import com.mokhtar.sarytask.data.model.catalog.CatalogResult
import com.mokhtar.sarytask.data.repo.local.DataStoreRepository
import com.mokhtar.sarytask.data.repo.remote.AppRepository
import com.mokhtar.sarytask.util.NetworkWrapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: AppRepository,
    private val dataStore: DataStoreRepository
) : ViewModel() {

    //region variables
    private var _bannerData = MutableLiveData<NetworkWrapper<List<Banner>>>()
    val bannerData: LiveData<NetworkWrapper<List<Banner>>> get() = _bannerData

    private var _catalogResult = MutableLiveData<NetworkWrapper<List<CatalogResult>>>()
    val catalogResult: LiveData<NetworkWrapper<List<CatalogResult>>> get() = _catalogResult

     val ds = dataStore.readData.asLiveData()

    //endregion

    //region helper functions
    fun getBanners(language:String) {

        viewModelScope.launch {

            repository.getBanners(language)
                .onStart { _bannerData.postValue(NetworkWrapper.Loading()) }
                .catch { exception ->
                    _bannerData.postValue(NetworkWrapper.Error(exception.message!!))
                }
                .collect { result ->
                    if (result.status) {
                        if (result.result.isNullOrEmpty())
                            _bannerData.value = NetworkWrapper.Empty()
                        else
                            _bannerData.postValue(NetworkWrapper.Success(result.result))
                    } else
                        _bannerData.postValue(NetworkWrapper.Error("Some thing wrong with server"))


                }
        }
    }

    fun getCatalogs(language:String) {
        Log.d(TAG, "get Catalogs: ")
        viewModelScope.launch {
            repository.getCatalog(language)
                .onStart { _catalogResult.postValue(NetworkWrapper.Loading()) }
                .catch { exception ->
                    _catalogResult.postValue(NetworkWrapper.Error(exception.message!!))
                }
                .collect { result ->
                    if (result.status) {
                        if (result.catalogResult.isNullOrEmpty())
                            _catalogResult.value = NetworkWrapper.Empty()
                        else
                            _catalogResult.postValue(NetworkWrapper.Success(result.validCatalogs))
                    } else
                        _catalogResult.postValue(NetworkWrapper.Error("Some thing wrong with server"))


                }
        }
    }

    fun saveToDataStore(language: String) = viewModelScope.launch(Dispatchers.IO) {
        dataStore.saveData(language)
    }

    //endregion


    companion object {
        private const val TAG = "HomeViewModel"
    }
}