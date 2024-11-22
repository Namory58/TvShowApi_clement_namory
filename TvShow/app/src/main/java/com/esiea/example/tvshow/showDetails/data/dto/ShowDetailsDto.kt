package com.esiea.example.tvshow.showDetails.data.dto


import com.esiea.example.tvshow.showDetails.domain.model.ShowDetails
import com.google.gson.annotations.SerializedName

data class ShowDetailsDto(
    @SerializedName("tvShow")
    val tvShow: TvShowDto
)

fun ShowDetailsDto.toShowDetail():ShowDetails{
    return ShowDetails(
        tvShow = tvShow
    )
}