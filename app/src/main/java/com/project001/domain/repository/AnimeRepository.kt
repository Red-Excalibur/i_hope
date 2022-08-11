package com.project001.domain.repository

import com.project001.data.remote.Data
import com.project001.data.remote.animeModel
import retrofit2.Response

interface AnimeRepository {
    suspend fun getAnimes(): Response<animeModel>
}