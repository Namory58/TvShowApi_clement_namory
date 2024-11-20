package com.esiea.example.tvshow.di

import com.esiea.example.tvshow.mostPopular.data.repository.NewRepositoryImpl
import com.esiea.example.tvshow.mostPopular.data.service.ApiConstants
import com.esiea.example.tvshow.mostPopular.data.service.NewApiService
import com.esiea.example.tvshow.mostPopular.domain.repository.NewsRepository
import com.esiea.example.tvshow.mostPopular.domain.useCase.GetNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {
    @Provides
    @Singleton
    fun provideNewsApiService(): NewApiService {
        return Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApiService: NewApiService): NewsRepository {
        return NewRepositoryImpl(newsApiService)
    }

    @Provides
    @Singleton
    fun provideGetNewsUseCase(repository: NewsRepository): GetNewsUseCase {
        return GetNewsUseCase(repository)
    }
}