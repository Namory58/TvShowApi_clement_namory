package com.esiea.example.tvshow.mostPopular.domain.useCase

import coil3.network.HttpException
import com.esiea.example.tvshow.mostPopular.data.dto.toReponse
import com.esiea.example.tvshow.mostPopular.data.dto.toTvShow
import com.esiea.example.tvshow.mostPopular.domain.model.TvShow
import com.esiea.example.tvshow.mostPopular.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(private val repository: NewsRepository){
    suspend operator fun invoke(page: Int): Flow<Ressource<List<TvShow>>> = flow {
        try {
            emit(Ressource.Loading<List<TvShow>>(isLoading = true))
            val response = repository.getTvShow(page)
            val tvShows = response.toReponse().tvShows.map { tvShow -> tvShow.toTvShow()}
            emit(Ressource.Success<List<TvShow>>(tvShows))
        } catch (e: IOException) {
            emit(Ressource.Error<List<TvShow>>(message = e.localizedMessage))
        }
        catch (e: HttpException) {
            emit(Ressource.Error<List<TvShow>>(message = "An unexpected error occurred"))
        }
    }
}