package com.mk.navigation

interface FeatureNavigator {
    fun navigate(route: String)
    fun navigateBack()
}