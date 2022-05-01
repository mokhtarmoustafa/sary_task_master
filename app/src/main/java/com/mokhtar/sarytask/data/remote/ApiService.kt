package com.mokhtar.sarytask.data.remote

import com.mokhtar.sarytask.data.model.banner.BannerResponse
import com.mokhtar.sarytask.data.model.catalog.CatalogResponse
import com.mokhtar.sarytask.util.HEADER_ACCEPT_LANGUAGE_KEY
import com.mokhtar.sarytask.util.RELATIVE_URL_BANNERS
import com.mokhtar.sarytask.util.RELATIVE_URL_CATALOGS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {
    @GET(RELATIVE_URL_BANNERS)
    suspend fun getBanners( @Header(HEADER_ACCEPT_LANGUAGE_KEY) language: String ): BannerResponse

    @GET(RELATIVE_URL_CATALOGS)
    suspend fun getCatalogs(@Header(HEADER_ACCEPT_LANGUAGE_KEY) language: String ): CatalogResponse
}