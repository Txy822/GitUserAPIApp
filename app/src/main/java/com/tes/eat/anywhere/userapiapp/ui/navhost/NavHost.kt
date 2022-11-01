package com.tes.eat.anywhere.userapiapp.ui.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.ui.HomeScreen
import com.tes.eat.anywhere.userapiapp.ui.ProfileScreen
import com.tes.eat.anywhere.userapiapp.ui.destinations.Home
import com.tes.eat.anywhere.userapiapp.ui.destinations.Profile


@Composable
fun APPNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    state: List<User>,

    ) {

    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen(
                state = state,
                navController = navController
            )
        }
        composable(
            "${Profile.route}?login={login} id={id} avatarUrl={avatarUrl}"
        ) { backStackEntry ->
            val userName = backStackEntry.arguments?.getString("login")
            val id = backStackEntry.arguments?.getString("id")
            val img= backStackEntry.arguments?.getString("avatarUrl")

            ProfileScreen(
                userName = userName!!,
                id = id!!,
                img=img!!,
                navController = navController
            )
        }
    }
}



