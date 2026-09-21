package com.example.mycity.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycity.R
import com.example.mycity.data.Category
import com.example.mycity.data.RecommendationRepository
import com.example.mycity.ui.CityWindowSize
import com.example.mycity.ui.rememberScaledImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    windowSize: CityWindowSize,
    onCategoryClick: (Category) -> Unit,
    modifier: Modifier = Modifier,
) {
    val categories = RecommendationRepository.categories
    var highlightedCategoryId by rememberSaveable { mutableStateOf<Int?>(null) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = stringResource(R.string.home_title)) },
            )
        },
    ) { innerPadding ->
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            if (windowSize != CityWindowSize.Compact) {
                CategoryNavigationRail(
                    categories = categories,
                    selectedCategoryId = highlightedCategoryId,
                    onCategoryClick = { category ->
                        highlightedCategoryId = category.id
                        onCategoryClick(category)
                    },
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                contentPadding = PaddingValues(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(categories, key = { it.id }) { category ->
                    HomeCategoryCard(
                        category = category,
                        onClick = {
                            highlightedCategoryId = category.id
                            onCategoryClick(category)
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun HomeCategoryCard(
    category: Category,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
    ) {
        Column {
            Image(
                painter = rememberScaledImagePainter(category.imageRes),
                contentDescription = stringResource(category.nameRes),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = stringResource(category.nameRes),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CategoryNavigationRail(
    categories: List<Category>,
    selectedCategoryId: Int?,
    onCategoryClick: (Category) -> Unit,
) {
    NavigationRail {
        categories.forEach { category ->
            NavigationRailItem(
                selected = category.id == selectedCategoryId,
                onClick = { onCategoryClick(category) },
                icon = {
                    Icon(
                        painter = painterResource(category.iconRes),
                        contentDescription = stringResource(category.nameRes),
                    )
                },
                label = { Text(text = stringResource(category.nameRes)) },
            )
        }
    }
}