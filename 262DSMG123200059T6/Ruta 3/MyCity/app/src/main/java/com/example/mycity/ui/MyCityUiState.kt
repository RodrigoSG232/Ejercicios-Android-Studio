package com.example.mycity.ui

import com.example.mycity.data.Category
import com.example.mycity.data.Recommendation

data class MyCityUiState(
    val currentCategory: Category? = null,
    val currentRecommendation: Recommendation? = null,
)