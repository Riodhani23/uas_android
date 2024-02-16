package com.r10.movieTMDB.data.network

import com.r10.movieTMDB.data.response.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String
    ): Call<CharacterResponse>
}
