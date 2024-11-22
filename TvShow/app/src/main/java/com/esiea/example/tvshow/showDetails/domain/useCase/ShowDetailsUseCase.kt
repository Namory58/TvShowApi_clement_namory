package com.esiea.example.tvshow.showDetails.domain.useCase

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import com.esiea.example.tvshow.showDetails.data.dto.toTvShow
import com.esiea.example.tvshow.showDetails.domain.model.TvShow
import com.esiea.example.tvshow.showDetails.domain.repository.GetShowDetailsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ShowDetailsUseCase  @Inject constructor(
    private val repository: GetShowDetailsRepository
)  {
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend operator fun invoke(q: String): Flow<Ressource<TvShow>> = flow {
        try {
            emit(Ressource.Loading<TvShow>())
            val response = repository.getShowDetail(q)
            val tvShow = response.toTvShow()
            emit(Ressource.Success(tvShow))
        } catch (e: IOException) {
            emit(Ressource.Error<TvShow>("Vérifiez votre connexion Internet."))
        } catch (e: HttpException) {
            emit(Ressource.Error<TvShow>("Une erreur inattendue s'est produite."))
        } catch (e: Exception) {
            emit(Ressource.Error<TvShow>(e.localizedMessage ?: "Erreur inconnue."))
        }
    }
}