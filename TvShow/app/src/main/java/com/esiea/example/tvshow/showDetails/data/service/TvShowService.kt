package com.esiea.example.tvshow.showDetails.data.service

import com.esiea.example.tvshow.showDetails.data.dto.TVShowDetailsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TVShowService {

    @GET("show-details")
    suspend fun getShowDetails(@Query("q") showName: String): Response<TVShowDetailsDto>
}
