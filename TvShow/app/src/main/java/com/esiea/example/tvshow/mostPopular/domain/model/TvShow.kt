package com.esiea.example.tvshow.mostPopular.domain.model

import java.io.Serializable

data class TvShow(
    val country: String,
    val id: Int,
    val imageThumbnailPath: String,
    val name: String,
    val startDate: String,
    val permalink: String,
):Serializable
