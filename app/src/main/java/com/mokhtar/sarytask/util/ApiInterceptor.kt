package com.mokhtar.sarytask.util

import okhttp3.Interceptor
import okhttp3.Response

//interceptor for add api key query  for each request
class ApiInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val requestHeaders = request.headers.newBuilder()
            .add(HEADER_DEVICE_TYPE_KEY, HEADER_DEVICE_TYPE_VALUE)
            .add(HEADER_APP_VERSION_KEY, HEADER_APP_VERSION_VALUE)
//            .add(HEADER_ACCEPT_LANGUAGE_KEY, HEADER_ACCEPT_LANGUAGE_EN_VALUE)
            .add(HEADER_PLATFORM_KEY, HEADER_PLATFORM_VALUE)
            .add(HEADER_AUTHORIZATION_KEY, HEADER_AUTHORIZATION_VALUE)
            .build();
        val requestBuilder = request.newBuilder().headers(requestHeaders)

        return chain.proceed(requestBuilder.build())
    }
}