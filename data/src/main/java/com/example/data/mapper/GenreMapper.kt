package com.example.data.mapper

import com.example.data.dto.GenreDto
import com.example.data.dto.GenreItemDto
import com.example.domain.model.GenreItemModel
import com.example.domain.model.GenreModel

class GenreMapper {

    fun fromRemoteToModel(obj:GenreDto):GenreModel{
        return GenreModel(
            genres = obj.genres.map {
                fromRemoteObjectToModel(it)
            }
        )
    }


    fun fromRemoteObjectToModel(obj:GenreItemDto):GenreItemModel{
        return  GenreItemModel(
            id = obj.id,
            name = obj.name
        )
    }

}