package com.example.movieApp

import com.example.data.mapper.GenreMapper
import com.example.data.mapper.MovieMapper
import com.example.data.remote.MovieApi
import com.example.data.repository.CatsRepositoryImpl
import com.example.data.repository.MovieRepositoryImpl
import com.example.domain.repository.CatsRepository
import com.example.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)


    @Provides
    @Singleton
    fun provideCatRepo(
        api: MovieApi, genreMapper: GenreMapper
    ): CatsRepository = CatsRepositoryImpl(api, genreMapper)

    @Provides
    @Singleton
    fun provideMovieRepo(
        api: MovieApi,movieMapper: MovieMapper
    ):MoviesRepository = MovieRepositoryImpl(api, movieMapper)

}