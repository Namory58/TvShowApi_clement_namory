package com.esiea.example.tvshow.showDetails.presentation.viewModel

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esiea.example.tvshow.showDetails.domain.model.TvShow
import com.esiea.example.tvshow.showDetails.domain.useCase.Ressource
import com.esiea.example.tvshow.showDetails.domain.useCase.ShowDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailsViewModel @Inject constructor(
    private val showDetailsUseCase: ShowDetailsUseCase
) : ViewModel() {

    private val _tvShowState = MutableStateFlow<Ressource<TvShow>>(Ressource.Loading())
    val tvShowState: StateFlow<Ressource<TvShow>> = _tvShowState

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getShowDetails(q: String) {
        viewModelScope.launch {
            showDetailsUseCase(q).collect { result ->
                _tvShowState.value = result
            }
        }
    }
}