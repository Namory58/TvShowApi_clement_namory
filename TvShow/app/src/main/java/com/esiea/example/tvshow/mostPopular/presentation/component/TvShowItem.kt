package com.esiea.example.tvshow.mostPopular.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.esiea.example.tvshow.mostPopular.domain.model.TvShow
import com.esiea.example.tvshow.ui.theme.Purple40

@Composable
fun TvShowItem(
    modifier: Modifier = Modifier,
    tvshows: TvShow,
    onClickTvShow : (TvShow)->Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .size(width = 240.dp, height = 350.dp)
            .padding(0.dp),
        onClick = {
            onClickTvShow(tvshows)
        }
    ){
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = tvshows.imageThumbnailPath,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(30.dp)
                    .weight(2f)
            )
            Column (
                modifier = Modifier
                .weight(1f)
            ){
                Text(
                    text =tvshows.name,
                    fontWeight = Bold,
                    color = Color.Black,
                    fontSize = 12.sp,
                    maxLines = 1,
                )
                Text(
                    text ="Sortie : "+ tvshows.startDate,
                    color = Purple40,
                    maxLines = 1,
                    fontSize = 10.sp,
                    modifier = modifier.padding(3.dp)
                )
                Text(
                    text ="Pays : "+ tvshows.country,
                    color = Purple40,
                    maxLines = 2,
                    fontSize = 12.sp,
                    modifier = modifier.padding(3.dp)
                )
            }
        }

    }

}
