package com.esiea.example.tvshow.showDetails.presentation.newState

import com.esiea.example.tvshow.showDetails.domain.model.TVShowDetails

data class TVShowDetailsState(
    val tvShowDetails: TVShowDetails? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
