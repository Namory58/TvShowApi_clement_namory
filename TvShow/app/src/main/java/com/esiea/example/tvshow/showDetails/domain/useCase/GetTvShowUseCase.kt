package com.esiea.example.tvshow.showDetails.domain.useCase

import com.esiea.example.tvshow.showDetails.domain.repository.TVShowRepository
import com.esiea.example.tvshow.showDetails.domain.model.TVShowDetails
import javax.inject.Inject

class GetTVShowDetailsUseCase @Inject constructor(
    private val tvShowRepository: TVShowRepository
) {
    suspend operator fun invoke(showName: String): Result<TVShowDetails> {
        val result = tvShowRepository.getTVShowDetails(showName)
        return result.map {
            TVShowDetails(
                title = it.title,
                description = it.description,
                imageUrl = it.image,
                year = it.year,
                rating = it.rating
            )
        }
    }
}