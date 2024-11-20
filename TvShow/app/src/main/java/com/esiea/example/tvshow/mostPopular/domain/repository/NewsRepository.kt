package com.esiea.example.tvshow.mostPopular.domain.repository

import com.esiea.example.tvshow.mostPopular.data.dto.ReponseDto

interface NewsRepository {
    suspend fun getTvShow(): ReponseDto
}