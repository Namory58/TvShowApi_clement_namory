package com.esiea.example.tvshow.showDetails.presentation.newState

import com.esiea.example.tvshow.mostPopular.domain.model.TvShow

data class NewsState(
    val isLoading : Boolean = false,
    val tvShows : List<TvShow> = emptyList(),
    val error : String = ""
)
