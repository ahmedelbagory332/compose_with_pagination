package com.example.presentation.ui.widget


import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.presentation.theme.darkWhite
import com.example.presentation.ui.component.ErrorHolder
import com.example.presentation.ui.component.LoadingIndicator
import com.example.presentation.ui.component.MovieItem
import com.example.presentation.ui.viewModels.MoviesViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun MovieList(viewModel: MoviesViewModel = hiltViewModel()) {


    Column(
        modifier = Modifier
            .background(darkWhite)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {


        val movies = viewModel.movies.value.movies!!.flow.collectAsLazyPagingItems()

        if (viewModel.movies.value.isLoading) {
            LoadingIndicator()
        } else if (viewModel.movies.value.error.isNotEmpty()) {
            ErrorHolder(text = viewModel.movies.value.error)
        } else {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(movies.itemCount) { index ->
                        Card(
                            backgroundColor = Color.White,
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize(),
                            elevation = 15.dp,
                        ) {

                            MovieItem(movies[index]!!)
                        }
                    }
                }
            )


        }

    }
}


