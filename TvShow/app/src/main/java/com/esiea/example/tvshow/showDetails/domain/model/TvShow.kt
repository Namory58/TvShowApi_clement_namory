package com.esiea.example.tvshow.showDetails.domain.model

import com.esiea.example.tvshow.showDetails.data.dto.EpisodeDto
import java.io.Serializable

data class TvShow(
    val id: Int,
    val name: String,
    val description: String,
    val imagePath: String,
    val episodes: List<EpisodeDto>,
    val genres: List<String>,
) :Serializable
