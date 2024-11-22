package com.esiea.example.tvshow.mostPopular.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.esiea.example.tvshow.mostPopular.presentation.screen.TvShowScreen
import com.esiea.example.tvshow.mostPopular.presentation.viewModel.NewsViewModel
import com.esiea.example.tvshow.showDetails.presentation.ShowDetaills
import com.esiea.example.tvshow.ui.theme.TvShowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    private val newsViewModel : NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TvShowTheme {
                TvShowScreen(
                    modifier = Modifier.fillMaxSize(),
                    newsViewModel = newsViewModel
                ){
                    val intent = Intent(this, ShowDetaills::class.java)
                    intent.putExtra("index",it)
                    startActivity(intent)
                }
            }
        }
    }
}
