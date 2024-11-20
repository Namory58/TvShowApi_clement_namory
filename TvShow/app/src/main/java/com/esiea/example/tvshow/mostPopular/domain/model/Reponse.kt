package com.esiea.example.tvshow.mostPopular.domain.model

import com.esiea.example.tvshow.mostPopular.data.dto.TvShowDto

data class Reponse(
    val page : Int,
    val tvShows: List<TvShowDto>
)
