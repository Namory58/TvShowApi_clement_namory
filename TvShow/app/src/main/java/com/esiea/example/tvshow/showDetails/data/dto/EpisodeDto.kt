package com.esiea.example.tvshow.showDetails.data.dto


import com.esiea.example.tvshow.showDetails.domain.model.Episode
import com.google.gson.annotations.SerializedName

data class EpisodeDto(
    @SerializedName("season")
    val season: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: Int,


    )
fun EpisodeDto.toEpisode():Episode{
    return Episode(
        season = season,
        episode = episode,
        name=name,
        airDate = airDate
    )
}
