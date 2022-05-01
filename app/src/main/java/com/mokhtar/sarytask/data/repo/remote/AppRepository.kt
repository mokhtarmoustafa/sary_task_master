package com.mokhtar.sarytask.data.repo.remote

import com.mokhtar.sarytask.data.model.banner.Banner
import com.mokhtar.sarytask.data.model.banner.BannerResponse
import com.mokhtar.sarytask.data.model.catalog.CatalogResponse
import com.mokhtar.sarytask.data.model.catalog.CatalogResult

import com.mokhtar.sarytask.data.remote.ApiService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class AppRepository @Inject constructor(private val service: ApiService) {

    suspend fun getBanners(language:String): Flow<BannerResponse> {
        return flow {
            val result = service.getBanners(language)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCatalog(language:String): Flow<CatalogResponse> {
        return flow {
            val result = service.getCatalogs(language)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }


}