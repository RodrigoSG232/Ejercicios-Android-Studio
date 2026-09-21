package com.example.mycity.data

data class Category(
    val id: Int,
    val nameRes: Int,
    val iconRes: Int,
    val imageRes: Int,
    val recommendations: List<Recommendation>,
)