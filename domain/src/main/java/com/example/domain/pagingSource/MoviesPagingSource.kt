package com.example.domain.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.domain.model.MovieItem
import com.example.domain.repository.MoviesRepository

class MoviesPagingSource(
    private val repository: MoviesRepository,
    val catId : String,
   val lang:String
) :PagingSource<Int,MovieItem>(){

    override fun getRefreshKey(state: PagingState<Int, MovieItem>): Int? {
      return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieItem> {
        return try {
            val page = params.key ?: 1
            val response = repository.getRemoteMovie(language = lang, genresId = catId, page = page)
            LoadResult.Page(
                data = response.moveList,
                prevKey = if (page==1)null else page.minus(1),
                nextKey = if (response.moveList.isEmpty()) null else page.plus(1)
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }
    }
}