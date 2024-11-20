package com.esiea.example.tvshow.mostPopular.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.example.tvshow.mostPopular.domain.useCase.GetNewsUseCase
import com.esiea.example.tvshow.mostPopular.domain.useCase.Ressource
import com.esiea.example.tvshow.mostPopular.presentation.newState.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase): ViewModel() {
    private val _newsState = mutableStateOf(NewsState())
    var newsState: State<NewsState> = _newsState

    init {
        getTvShow()
    }

    private fun getTvShow() = viewModelScope.launch(Dispatchers.IO) {
        getNewsUseCase.invoke().onEach {
            when (it) {
                is Ressource.Error -> {
                    _newsState.value = NewsState(error = "Unexpected error occurented")
                }

                is Ressource.Loading -> {
                    _newsState.value = NewsState(isLoading = true)
                }

                is Ressource.Success -> {
                    Log.d("data", "Data fetched successfully: ${it.data}")
                    _newsState.value = NewsState(
                        tvShows = it.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}