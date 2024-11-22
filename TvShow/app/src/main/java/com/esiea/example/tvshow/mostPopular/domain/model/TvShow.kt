package com.esiea.example.tvshow.mostPopular.domain.model

import java.io.Serializable

data class TvShow(
    val id: Int,
    val name: String,
    val country: String,
    val permalink: String,
    val startDate: String,
    val imageThumbnailPath: String,

):Serializable
