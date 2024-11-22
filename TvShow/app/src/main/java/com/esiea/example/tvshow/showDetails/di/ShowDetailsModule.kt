package com.esiea.example.tvshow.showDetails.di

import com.esiea.example.tvshow.showDetails.data.repository.GetShowDetailsRepositorylmpl
import com.esiea.example.tvshow.showDetails.data.service.ApiConstants
import com.esiea.example.tvshow.showDetails.data.service.getShowApiDetails
import com.esiea.example.tvshow.showDetails.domain.repository.GetShowDetailsRepository
import com.esiea.example.tvshow.showDetails.domain.useCase.ShowDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShowDetailsModule {
    @Provides
    @Singleton
    fun provideNewsApiService():getShowApiDetails {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(getShowApiDetails::class.java)
    }
    @Provides
    @Singleton
    fun provideNewsRepository(getApiServiceShowDetails: getShowApiDetails): GetShowDetailsRepository {
        return GetShowDetailsRepositorylmpl(getApiServiceShowDetails)
    }
    @Provides
    @Singleton
    fun provideGetNewsUseCase(repository: GetShowDetailsRepository):ShowDetailsUseCase  {
        return ShowDetailsUseCase(repository)
    }
}