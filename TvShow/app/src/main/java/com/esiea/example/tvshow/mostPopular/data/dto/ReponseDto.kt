package com.esiea.example.tvshow.mostPopular.data.dto


import com.esiea.example.tvshow.mostPopular.domain.model.Reponse
import com.google.gson.annotations.SerializedName

data class ReponseDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("total")
    val total: String,
    @SerializedName("tv_shows")
    val tvShows: List<TvShowDto>
)

fun ReponseDto.toReponse():Reponse{
    return Reponse(
        page =page,
        tvShows = tvShows
    )
}