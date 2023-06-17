package com.example.domain.use_case

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.domain.model.GenreModel
import com.example.domain.model.MovieItem
import com.example.domain.pagingSource.MoviesPagingSource
import com.example.domain.repository.CatsRepository
import com.example.domain.repository.MoviesRepository
import com.example.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(private val repository: MoviesRepository) {

    operator fun invoke(lang:String,catId:String): Flow<Resource<Pager<Int,MovieItem>>> = flow {
        try {
            emit(Resource.Loading<Pager<Int,MovieItem>>())
            val getMovies = Pager(
                config = PagingConfig(pageSize = 10),
                pagingSourceFactory = {
                    MoviesPagingSource(repository,catId,lang)
                }
            )
        }catch (e:Exception){
            emit(Resource.Error<Pager<Int,MovieItem>>("${e.localizedMessage} : An unexpected error happened"))
        }

    }
}

