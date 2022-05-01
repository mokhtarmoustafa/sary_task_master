package com.mokhtar.sarytask.util

import androidx.annotation.Keep


@Keep
sealed class NetworkWrapper<T> {

  class Init<T> : NetworkWrapper<T>()

  class Loading<T> : NetworkWrapper<T>()

  class LoadMore<T> : NetworkWrapper<T>()

  data class Success<T>(val data: T) : NetworkWrapper<T>()

  data class Error<T>(val errorMessage: String = "") : NetworkWrapper<T>()

  class Empty<T>: NetworkWrapper<T>()
}