package com.esiea.example.tvshow.mostPopular.data.repository

import com.esiea.example.tvshow.mostPopular.data.dto.ReponseDto
import com.esiea.example.tvshow.mostPopular.data.service.NewApiService
import com.esiea.example.tvshow.mostPopular.domain.repository.NewsRepository
import javax.inject.Inject

class NewRepositoryImpl @Inject constructor (private val newApiService: NewApiService):
    NewsRepository {
    override suspend fun getTvShow(page: Int): ReponseDto {
        return newApiService.getMostPopularTvShows()
    }
}