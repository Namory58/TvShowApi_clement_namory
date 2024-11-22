package com.esiea.example.tvshow.showDetails.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.esiea.example.tvshow.mostPopular.presentation.viewModel.NewsViewModel
import com.esiea.example.tvshow.showDetails.data.dto.EpisodeDto
import com.esiea.example.tvshow.showDetails.domain.model.TvShow
import com.esiea.example.tvshow.showDetails.presentation.ShowDetaills
import com.esiea.example.tvshow.showDetails.presentation.ui.theme.TvShowTheme
import com.esiea.example.tvshow.showDetails.presentation.viewModel.ShowDetailsViewModel

@Composable
fun ShowDetailItem(
    modifier: Modifier = Modifier,
    showDetails: ShowDetailsViewModel = hiltViewModel(),
    index: TvShow = TvShow(
        id = 35624,
        name = "The Flash",
        description = "Barry Allen becomes the fastest man alive and fights crime as The Flash.",
        imagePath = "https://static.episodate.com/images/tv-show/thumbnail/35624.jpg",
        episodes = listOf(
            EpisodeDto(1, "Winter is Coming", "2014-10-07",1),
            EpisodeDto(2, "Winter is Coming", "2014-10-14",1)
        ),
        genres = listOf("Action", "Adventure", "Drama")
    )
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Image
        AsyncImage(
            model = index.imagePath,
            contentDescription = "Poster of ${index.name}",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(MaterialTheme.colorScheme.surface),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
            text = index.name,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Genres
        Text(
            text = index.genres.joinToString(", "),
            color = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Text(
            text = index.description,
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Episodes
        Text(
            text = "Episodes:",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        index.episodes.forEach { episode ->
            Text(
                text = "${episode.season}. ${episode.name} (${episode.airDate})",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowDetailItemPreview() {
        ShowDetailItem()
}
