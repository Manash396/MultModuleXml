package com.mk.multimodulexml.navigation

import androidx.core.net.toUri
import androidx.navigation.NavController
import com.mk.navigation.FeatureNavigator

class NavigationDispatcher(
    private val navController: NavController
) : FeatureNavigator {

    override fun navigate(route: String) {
        navController.navigate(route.toUri())
    }

    override fun navigateBack() {
        navController.popBackStack()
    }
}