package com.esiea.example.tvshow.mostPopular.data.service

import com.esiea.example.tvshow.mostPopular.data.dto.ReponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewApiService {
    @GET(ApiConstants.MOST_POPULAR)
    suspend fun getMostPopularTvShows(
        @Query("page")
        page: Int = ApiConstants.PAGE
    ): ReponseDto
}