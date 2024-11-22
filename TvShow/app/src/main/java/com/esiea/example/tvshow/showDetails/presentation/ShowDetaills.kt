package com.esiea.example.tvshow.showDetails.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.esiea.example.tvshow.showDetails.domain.model.TvShow
import com.esiea.example.tvshow.showDetails.presentation.screen.ShowDetailItem
import com.esiea.example.tvshow.showDetails.presentation.ui.theme.TvShowTheme
import dagger.hilt.EntryPoint

class ShowDetaills : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val permalink = intent.getStringExtra("index") //  le parmlink
        Log.d("permalink","$permalink")
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TvShowTheme {

            }
        }
    }
}

