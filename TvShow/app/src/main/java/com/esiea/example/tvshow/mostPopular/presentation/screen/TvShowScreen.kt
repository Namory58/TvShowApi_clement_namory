package com.esiea.example.tvshow.mostPopular.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.esiea.example.tvshow.mostPopular.domain.model.TvShow
import com.esiea.example.tvshow.mostPopular.presentation.component.TvShowItem
import com.esiea.example.tvshow.mostPopular.presentation.viewModel.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TvShowScreen(
    modifier: Modifier = Modifier,
    newsViewModel: NewsViewModel = hiltViewModel(),
    onClickOnTvShows: (String) -> Unit
    ) {

    val stateResult = newsViewModel.newsState.value

    Scaffold(modifier = modifier.fillMaxSize(),
        containerColor = Color.White,
        topBar = {
                TopAppBar(
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("TV Show")
                    }
                )

        },
    ) {innerPadding->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White),
        )
        {
            LazyColumn(
                modifier = modifier.fillMaxSize(),
                contentPadding = PaddingValues(9.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    space = 1.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                items(stateResult.tvShows){
                        tvshow :TvShow ->
                    TvShowItem(tvshows = tvshow){
                        onClickOnTvShows(tvshow.permalink)
                    }
                }
            }
            Row(
                modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(130.dp)
                )

            {
                Button(
                    onClick = {
                        newsViewModel.loadLastPage()
                    }
                ) {
                    Text("précedant")
                }
                Button(
                    onClick = {
                        newsViewModel.loadNextPage()
                    }
                ) {
                    Text("suivant")
                }
            }

            if (stateResult.isLoading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }

}