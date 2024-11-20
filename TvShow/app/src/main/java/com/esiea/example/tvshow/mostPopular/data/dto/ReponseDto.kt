package com.esiea.example.tvshow.mostPopular.data.dto


import com.google.gson.annotations.SerializedName

data class ReponseDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("total")
    val total: String,
    @SerializedName("tv_shows")
    val tvShows: List<TvShow>
)