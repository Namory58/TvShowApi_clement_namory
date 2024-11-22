package com.esiea.example.tvshow.showDetails.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.example.tvshow.showDetails.domain.useCase.GetTVShowDetailsUseCase
import com.esiea.example.tvshow.showDetails.domain.useCase.Ressource
import com.esiea.example.tvshow.showDetails.presentation.newState.TVShowDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TVShowDetailsViewModel @Inject constructor(
    private val getTVShowDetailsUseCase: GetTVShowDetailsUseCase
) : ViewModel() {

    private val _tvShowDetailsState = mutableStateOf(TVShowDetailsState())
    val tvShowDetailsState: State<TVShowDetailsState> = _tvShowDetailsState

    fun getTVShowDetails(showName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            getTVShowDetailsUseCase(showName).onEach { result ->
                when (result) {
                    is Ressource.Error -> {
                        _tvShowDetailsState.value = TVShowDetailsState(error = "Unexpected error occurred")
                    }

                    is Ressource.Loading -> {
                        _tvShowDetailsState.value = TVShowDetailsState(isLoading = true)
                    }

                    is Ressource.Success -> {
                        Log.d("TVShowDetails", "Data fetched successfully: ${result.data}")
                        _tvShowDetailsState.value = TVShowDetailsState(
                            tvShowDetails = result.data,
                            isLoading = false
                        )
                    }
                }
            }.launchIn(viewModelScope)
        }
    }
}
