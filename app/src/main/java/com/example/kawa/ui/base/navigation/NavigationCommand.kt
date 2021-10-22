package com.example.kawa.ui.base.navigation

import androidx.navigation.NavDirections

/**
 * Sealed class for Navigation in jetpack
 *
 */
sealed class NavigationCommand {
    data class To(val directions: NavDirections) : NavigationCommand()
    object Back : NavigationCommand()
    data class BackTo(val destinationId: Int) : NavigationCommand()
    object ToRoot : NavigationCommand()
}