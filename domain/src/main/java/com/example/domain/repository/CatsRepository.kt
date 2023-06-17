package com.example.domain.repository

import com.example.domain.model.GenreModel

interface CatsRepository {
    suspend fun getCats(lang:String):GenreModel
}