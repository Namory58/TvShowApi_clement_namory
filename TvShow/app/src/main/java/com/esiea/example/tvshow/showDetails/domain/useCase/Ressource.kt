package com.esiea.example.tvshow.showDetails.domain.useCase

sealed class Ressource<out T> {
    data class Success<out T>(val data: T?) : Ressource<T>()
    data class Error(val message: String) : Ressource<Nothing>()
    object Loading : Ressource<Nothing>()
}
