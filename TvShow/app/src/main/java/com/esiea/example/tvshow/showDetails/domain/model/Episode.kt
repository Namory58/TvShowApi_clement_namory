package com.esiea.example.tvshow.showDetails.domain.model

import java.io.Serializable

data class Episode(
    val season :Int,
    val episode :Int,
    val name :String,
    val airDate: String,
):Serializable
