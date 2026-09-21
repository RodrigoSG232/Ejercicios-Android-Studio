package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.Category
import com.example.mycity.data.Recommendation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    fun updateCurrentCategory(category: Category) {
        _uiState.update { it.copy(currentCategory = category) }
    }

    fun updateCurrentRecommendation(recommendation: Recommendation) {
        _uiState.update { it.copy(currentRecommendation = recommendation) }
    }

    fun resetRecommendation() {
        _uiState.update { it.copy(currentRecommendation = null) }
    }

    fun resetState() {
        _uiState.value = MyCityUiState()
    }
}