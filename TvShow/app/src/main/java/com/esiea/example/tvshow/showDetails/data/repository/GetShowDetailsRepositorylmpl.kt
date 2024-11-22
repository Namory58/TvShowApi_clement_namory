package com.esiea.example.tvshow.showDetails.data.repository


import com.esiea.example.tvshow.showDetails.data.dto.TvShowDto
import com.esiea.example.tvshow.showDetails.data.service.getShowApiDetails
import com.esiea.example.tvshow.showDetails.domain.repository.GetShowDetailsRepository
import javax.inject.Inject

class GetShowDetailsRepositorylmpl @Inject constructor(private val getApiDetails: getShowApiDetails)
    : GetShowDetailsRepository{
    override suspend fun getShowDetail(q: String): TvShowDto {
        return getApiDetails.getTvShowsDtails()
    }
}