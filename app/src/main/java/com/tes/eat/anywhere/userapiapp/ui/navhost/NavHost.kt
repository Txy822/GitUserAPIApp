package com.tes.eat.anywhere.userapiapp.ui.navhost

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.ui.HomeScreen
import com.tes.eat.anywhere.userapiapp.ui.ProfileScreen
import com.tes.eat.anywhere.userapiapp.ui.UserViewModel
import com.tes.eat.anywhere.userapiapp.ui.destinations.Home
import com.tes.eat.anywhere.userapiapp.ui.destinations.Profile


@Composable
fun APPNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    homeUserViewModel: UserViewModel,
    state: List<User>,
    //state: List<Data>,
    //person:PeopleItem,
    userName:String="Tesfahun"
    ){

        NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
        ) {
            composable(route = Home.route) {
                HomeScreen(
                state =state,
                    navController= navController
            )
        }
            composable(
                "${Profile.route}?login={login} id={id}"
            ) {
                    backStackEntry ->
                val userName = backStackEntry.arguments?.getString("login")
                val id = backStackEntry.arguments?.getString("id")

                ProfileScreen(userName= userName!!,id=id!!,
                navController= navController)
            }

    }
}



