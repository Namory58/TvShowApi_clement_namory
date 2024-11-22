package com.esiea.example.tvshow.showDetails.domain.repository

import com.esiea.example.tvshow.showDetails.data.dto.TvShowDto


interface GetShowDetailsRepository {
    suspend fun getShowDetail(q: String): TvShowDto
}