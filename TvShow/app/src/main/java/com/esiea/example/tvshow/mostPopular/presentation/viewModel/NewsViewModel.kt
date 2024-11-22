package com.esiea.example.tvshow.mostPopular.presentation.viewModel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.example.tvshow.mostPopular.data.service.ApiConstants
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
    private var currentPage = ApiConstants.PAGE

    init {
        getTvShow(currentPage)
    }

    private fun getTvShow(page: Int) = viewModelScope.launch(Dispatchers.IO) {
        getNewsUseCase.invoke(page).onEach {
            when (it) {
                is Ressource.Error -> {
                    _newsState.value = NewsState(error = "Unexpected error occurred")
                }
                is Ressource.Loading -> {
                    _newsState.value = NewsState(isLoading = true)
                }
                is Ressource.Success -> {
                    _newsState.value = NewsState(
                        tvShows = it.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun loadNextPage() {
        currentPage += 1
        ApiConstants.PAGE = currentPage
        Log.d("pageS", "$currentPage")
        getTvShow(currentPage)
    }
    fun loadLastPage(){
        if (currentPage > 1) {
            currentPage -= 1
            ApiConstants.PAGE = currentPage
        } else {
            ApiConstants.PAGE = 1
            currentPage = 1
        }
        Log.d("pageP", "$currentPage")
        getTvShow(currentPage)
    }
}
