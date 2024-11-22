package com.esiea.example.tvshow.showDetails.domain.repository

import com.esiea.example.tvshow.showDetails.data.dto.TVShowDetailsDto

interface TVShowRepository {
    suspend fun getTVShowDetails(showName: String): Result<TVShowDetailsDto>
}