package com.tes.eat.anywhere.userapiapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.tes.eat.anywhere.userapiapp.ui.navhost.APPNavHost
import com.tes.eat.anywhere.userapiapp.ui.theme.UserAPIAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserApiApp()
        }
    }
}

@Composable
fun UserApiApp(){
    UserAPIAppTheme {
        val navController = rememberNavController()
        val homeUserViewModel = viewModel(modelClass = UserViewModel::class.java)
        val state by homeUserViewModel.personState
        APPNavHost(navController = navController, modifier = Modifier, homeUserViewModel, state)
    }
}





