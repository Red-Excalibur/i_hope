package com.project001.data

import com.project001.data.remote.AnimeAPI
import com.project001.data.remote.Data
import com.project001.data.remote.animeModel
import com.project001.domain.repository.AnimeRepository
import retrofit2.Response
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val animeApi:AnimeAPI
):AnimeRepository {
    override suspend fun getAnimes(): Response<animeModel> {
        return animeApi.getAnimes()
    }
}