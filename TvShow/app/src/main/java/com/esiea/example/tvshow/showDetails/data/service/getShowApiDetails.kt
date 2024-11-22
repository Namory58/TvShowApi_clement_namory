package com.esiea.example.tvshow.showDetails.data.service

import com.esiea.example.tvshow.showDetails.data.dto.TvShowDto
import retrofit2.http.GET
import retrofit2.http.Query

interface getShowApiDetails {
    @GET(ApiConstants.SHOW_DETAILS)
    suspend fun getTvShowsDtails(
        @Query("q")
        q: String = ApiConstants.Q
    ):TvShowDto
}