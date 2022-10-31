package com.tes.eat.anywhere.userapiapp.ui.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector
import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem

interface Destination {

       // val icon: ImageVector
        val route: String
}

object Home : Destination {
    //override val icon = Icons.Filled.AccountBox
    override val route = "home"
}

object Profile : Destination {
   // override val icon = Icons.Filled.Add
    override val route = "profile"
    private val person:PeopleItem = PeopleItem()
    val routeWithArgs = "$route/{$person}"
}