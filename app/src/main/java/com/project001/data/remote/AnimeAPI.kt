package com.project001.data.remote

import retrofit2.Response
import retrofit2.http.GET


interface AnimeAPI {

    @GET("api/v1")
    suspend fun getAnimes():Response<animeModel>
}