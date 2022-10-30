package com.tes.eat.anywhere.userapiapp.ui.navhost

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.PeopleItem
import com.tes.eat.anywhere.userapiapp.ui.HomeScreen
import com.tes.eat.anywhere.userapiapp.ui.ProfileScreen
import com.tes.eat.anywhere.userapiapp.ui.ViewModel
import com.tes.eat.anywhere.userapiapp.ui.destinations.Home
import com.tes.eat.anywhere.userapiapp.ui.destinations.Profile


@Composable
fun APPNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    homeViewModel: ViewModel,
    state: List<PeopleItem>,
    //person:PeopleItem
    userName:String="Tesfahun"

) {

    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            HomeScreen(
                onClickItems = {
                    //NavRoutes.Welcome.route + "/$userName"
                               navController.navigate(Profile.route + "/$userName")
                },

                homeViewModel=  homeViewModel,
                state =state
            )
        }
        composable(route = Profile.route + "/{userName}") { backStackEntry ->

            val userName = backStackEntry.arguments?.getString("userName")
            ProfileScreen(userName!!)
        }

    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {

        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }


