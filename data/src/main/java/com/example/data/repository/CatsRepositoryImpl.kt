package com.example.data.repository

import com.example.data.mapper.GenreMapper
import com.example.data.remote.MovieApi
import com.example.domain.model.GenreModel
import com.example.domain.repository.CatsRepository
import javax.inject.Inject

class CatsRepositoryImpl @Inject constructor(
    private val api: MovieApi,
    private val genreMapper: GenreMapper
) : CatsRepository {

    override suspend fun getCats(lang: String): GenreModel {
       return genreMapper.fromRemoteToModel(api.getCats(lang))
    }
}