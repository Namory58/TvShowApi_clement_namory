package com.esiea.example.tvshow.mostPopular.domain.useCase

sealed class Ressource<T>(val data : T? = null, val message : String? = null) {
    class Success<T>(data: T?) : Ressource<T>(data)
    class Error<T>(message: String?, data: T? = null) : Ressource<T>(data, message)
    class Loading<T>(val isLoading: Boolean = true) : Ressource<T>(data = null)
}