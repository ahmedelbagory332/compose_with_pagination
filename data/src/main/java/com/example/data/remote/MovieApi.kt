package com.example.data.remote

import com.example.data.Constant
import com.example.data.dto.GenreDto
import com.example.data.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi {


    @GET("genre/movie/list?api_key=${Constant.ApiKey}")
    suspend fun getCats(
        @Query("language") language: String = "en",
        ):GenreDto

    @GET("discover/movie?api_key=${Constant.ApiKey}")
    suspend fun getMovies(
        @Query("with_genres") genresId:String,
        @Query("page") page: Int,
        @Query("language") language: String = "en",
    ): MovieDto
}