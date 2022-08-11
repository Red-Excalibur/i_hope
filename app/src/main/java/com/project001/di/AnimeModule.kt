package com.project001.di

import com.project001.common.Constantes.BASE_URL
import com.project001.data.AnimeRepositoryImpl
import com.project001.data.remote.AnimeAPI
import com.project001.domain.repository.AnimeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AnimeModule {
    @Provides
    @Singleton
     fun provideApi():AnimeAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api:AnimeAPI):AnimeRepository {
        return AnimeRepositoryImpl(api)
    }
}