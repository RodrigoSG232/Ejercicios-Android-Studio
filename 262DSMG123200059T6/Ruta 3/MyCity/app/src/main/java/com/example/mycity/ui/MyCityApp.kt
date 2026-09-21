package com.example.mycity.ui

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.ui.category.CategoryScreen
import com.example.mycity.ui.detail.DetailScreen
import com.example.mycity.ui.home.HomeScreen

private const val HOME_ROUTE = "home"
private const val CATEGORY_ROUTE = "category"
private const val DETAIL_ROUTE = "detail"

private object ScreenTransitions {
    private val spec = tween<Float>(durationMillis = 300, easing = FastOutSlowInEasing)

    val enter: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
        scaleIn(
            animationSpec = spec,
            initialScale = 0.96f,
        ) + fadeIn(animationSpec = spec)
    }

    val exit: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
        scaleOut(
            animationSpec = spec,
            targetScale = 0.96f,
        ) + fadeOut(animationSpec = spec)
    }

    val popEnter: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = {
        scaleIn(
            animationSpec = spec,
            initialScale = 0.96f,
        ) + fadeIn(animationSpec = spec)
    }

    val popExit: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = {
        scaleOut(
            animationSpec = spec,
            targetScale = 0.96f,
        ) + fadeOut(animationSpec = spec)
    }
}

enum class CityWindowSize {
    Compact,
    Medium,
    Expanded,
}

@Composable
fun MyCityApp(
    modifier: Modifier = Modifier,
    viewModel: MyCityViewModel = viewModel(),
) {
    val windowSize = rememberCityWindowSize()
    val uiState by viewModel.uiState.collectAsState()

    val navController = rememberNavController()

    LaunchedEffect(uiState.currentCategory, uiState.currentRecommendation) {
        val destination = navController.currentDestination?.route
        when {
            destination == HOME_ROUTE && uiState.currentCategory != null ->
                navController.navigate(CATEGORY_ROUTE)

            destination == CATEGORY_ROUTE && uiState.currentRecommendation != null ->
                navController.navigate(DETAIL_ROUTE)
        }
    }

    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            when (backStackEntry?.destination?.route) {
                CATEGORY_ROUTE -> viewModel.resetRecommendation()
                HOME_ROUTE -> viewModel.resetState()
                else -> Unit
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = modifier,
    ) {
        composable(
            route = HOME_ROUTE,
            enterTransition = ScreenTransitions.enter,
            exitTransition = ScreenTransitions.exit,
            popEnterTransition = ScreenTransitions.popEnter,
            popExitTransition = ScreenTransitions.popExit,
        ) {
            HomeScreen(
                windowSize = windowSize,
                onCategoryClick = viewModel::updateCurrentCategory,
            )
        }
        composable(
            route = CATEGORY_ROUTE,
            enterTransition = ScreenTransitions.enter,
            exitTransition = ScreenTransitions.exit,
            popEnterTransition = ScreenTransitions.popEnter,
            popExitTransition = ScreenTransitions.popExit,
        ) {
            uiState.currentCategory?.let { category ->
                CategoryScreen(
                    category = category,
                    windowSize = windowSize,
                    onRecommendationClick = viewModel::updateCurrentRecommendation,
                    onBackClick = { navController.popBackStack() },
                )
            }
        }
        composable(
            route = DETAIL_ROUTE,
            enterTransition = ScreenTransitions.enter,
            exitTransition = ScreenTransitions.exit,
            popEnterTransition = ScreenTransitions.popEnter,
            popExitTransition = ScreenTransitions.popExit,
        ) {
            uiState.currentRecommendation?.let { recommendation ->
                DetailScreen(
                    recommendation = recommendation,
                    windowSize = windowSize,
                    onBackClick = { navController.popBackStack() },
                )
            }
        }
    }
}

@Composable
private fun rememberCityWindowSize(): CityWindowSize {
    val widthDp = LocalConfiguration.current.screenWidthDp
    return when {
        widthDp < 600 -> CityWindowSize.Compact
        widthDp < 840 -> CityWindowSize.Medium
        else -> CityWindowSize.Expanded
    }
}