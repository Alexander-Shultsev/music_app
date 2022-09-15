package com.example.musucapp.ui.navigation

import android.annotation.SuppressLint
import android.icu.text.CaseMap
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musucapp.R
import com.example.musucapp.navController
import com.example.musucapp.ui.screen.my_songs.MySongsScreen
import com.example.musucapp.ui.screen.sign_in.SignInScreen
import com.example.musucapp.ui.screen.sign_up.SignUpScreen
import okhttp3.Route



@Composable
fun Navigation() {
    NavHostMain()
}

sealed class NavMenuItems (
    val route: String,
    val title: String,
    val icon: Int
) {
    object MySongs: NavMenuItems(
        route = "MySongs",
        title = "My songs",
        icon = R.drawable.ic_nav_music
    )
    object CurrentLocation: NavMenuItems(
        route = "CurrentLocation",
        title = "Current location",
        icon = R.drawable.ic_nav_location
    )
}

sealed class NavItems(
    val route: String
) {
    object SignIn: NavItems("SignIn")
    object SignUp: NavItems("SignUp")
    object AddSongs: NavItems("AddSongs")
    object UpdateSongs: NavItems("UpdateSongs")
}

fun navigateTo(item: String) {
    navController.navigate(item) {
        launchSingleTop = true
        popUpTo(navController.graph.findStartDestination().id) {
            saveState = true
        }
        restoreState = true
    }
}

@Composable
fun NavHostMain() {
    NavHost(
        navController = navController,
        startDestination = NavItems.SignIn.route
    ) {
        composable(NavItems.SignIn.route) {
            SignInScreen()
        }
        composable(NavItems.SignUp.route) {
            SignUpScreen()
        }
        composable(NavMenuItems.MySongs.route) {
            MySongsScreen()
        }
    }
}