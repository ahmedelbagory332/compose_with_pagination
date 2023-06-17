package com.example.domain.use_case

import com.example.domain.model.GenreModel
import com.example.domain.repository.CatsRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GenreUseCase @Inject constructor(private val repository: CatsRepository) {

    operator fun invoke(lang:String): Flow<Resource<GenreModel>> = flow {
        try {
            emit(Resource.Loading<GenreModel>())
            val cats = repository.getCats(lang)
            emit(Resource.Success<GenreModel>(cats))
        }catch (e:Exception){
            emit(Resource.Error<GenreModel>("${e.localizedMessage} : An unexpected error happened"))
        }

    }
}

