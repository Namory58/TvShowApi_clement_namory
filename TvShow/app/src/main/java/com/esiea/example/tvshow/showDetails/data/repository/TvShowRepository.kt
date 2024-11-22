package com.esiea.example.tvshow.showDetails.data.repository

import com.esiea.example.tvshow.showDetails.data.service.TVShowService
import com.esiea.example.tvshow.showDetails.data.dto.TVShowDetailsDto
import javax.inject.Inject

class TVShowRepository @Inject constructor(
    private val tvShowService: TVShowService
) {
    suspend fun getTVShowDetails(showName: String): Result<TVShowDetailsDto> {
        return try {
            val response = tvShowService.getShowDetails(showName)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Failed to fetch details"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
