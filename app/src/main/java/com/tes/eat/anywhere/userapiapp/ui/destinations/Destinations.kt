package com.tes.eat.anywhere.userapiapp.ui.destinations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector

interface Destination {

        val icon: ImageVector
        val route: String
}

object Home : Destination {
    override val icon = Icons.Filled.AccountBox
    override val route = "overview"
}

object Profile : Destination {
    override val icon = Icons.Filled.Add
    override val route = "accounts"
}