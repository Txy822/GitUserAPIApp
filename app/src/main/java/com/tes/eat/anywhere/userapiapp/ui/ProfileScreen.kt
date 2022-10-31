package com.tes.eat.anywhere.userapiapp.ui

import androidx.compose.runtime.Composable

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tes.eat.anywhere.userapiapp.R
import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun  ProfileScreen(userName:String, navController: NavController) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Top appbar
                    TopAppbarProfile(context = LocalContext.current.applicationContext,navController)

                    ProfileDetail(username =userName)
                }
}

private val optionsList: ArrayList<OptionsData> = ArrayList()

@Composable
fun TopAppbarProfile(context: Context,navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.background,
        elevation = 4.dp,
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
                Toast.makeText(context, "Nav Button", Toast.LENGTH_SHORT).show()

            }) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Go back",

                )
            }
        }
    )
}

@Composable
fun  ProfileDetail(username:String, context: Context = LocalContext.current.applicationContext) {

    var listPrepared by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            optionsList.clear()

            prepareOptionsData()

            listPrepared = true
        }
    }

    if (listPrepared) {

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {

            item {
                // User's image, name, email and edit button
                UserDetails(context = context, username)
            }

            items(optionsList) { item ->
                OptionsItemStyle(item = item, context = context)
            }

        }
    }
}

// This composable displays user's image, name, email and edit button
@Composable
private fun UserDetails(context: Context, username: String) {
    //val imagePainter = rememberAsyncImagePainter(person.avatarModel)
    val imagePainter = rememberAsyncImagePainter( R.drawable.ic_launcher_background)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // User's image
        Image(
            modifier = Modifier
                .size(72.dp)
                .clip(shape = CircleShape),
            painter = imagePainter,
           // painter = painterResource(id = R.drawable.ic_launcher_background),

            contentDescription = "Your Image"
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {

                // User's name
                Text(
                    text = username,
                    style = TextStyle(
                        fontSize = 22.sp,
                       // fontFamily = FontFamily(Font(R., FontWeight.Bold)),
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(2.dp))

                // User's email
                Text(
                    text = "abcd123@gmail.com",
                    style = TextStyle(
                        fontSize = 14.sp,
                        color = Color.Gray,
                        letterSpacing = (0.8).sp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Edit button
            IconButton(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                onClick = {
                    Toast.makeText(context, "Edit Button", Toast.LENGTH_SHORT).show()
                }) {
                Icon(
                    modifier = Modifier.size(24.dp),
                    imageVector = Icons.Outlined.Edit,
                    contentDescription = "Edit Details",
                    tint = MaterialTheme.colors.primary
                )
            }

        }
    }
}

// Row style for options
@Composable
private fun OptionsItemStyle(item: OptionsData, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = true) {
                Toast
                    .makeText(context, item.title, Toast.LENGTH_SHORT)
                    .show()
            }
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Icon
        Icon(
            modifier = Modifier
                .size(32.dp),
            imageVector = item.icon,
            contentDescription = item.title,
            tint = MaterialTheme.colors.primary
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(weight = 3f, fill = false)
                    .padding(start = 16.dp)
            ) {

                // Title
                Text(
                    text = item.title,
                    style = TextStyle(
                        fontSize = 18.sp,
                       // fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium))
                    )
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Sub title
                Text(
                    text = item.subTitle,
                    style = TextStyle(
                        fontSize = 14.sp,
                        letterSpacing = (0.8).sp,
                       // fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        color = Color.Gray
                    )
                )

            }

            // Right arrow icon
            Icon(
                modifier = Modifier
                    .weight(weight = 1f, fill = false),
                imageVector = Icons.Outlined.ArrowDropDown,
                contentDescription = item.title,
                tint = Color.Black.copy(alpha = 0.70f)
            )
        }

    }
}

private fun prepareOptionsData() {

    val appIcons = Icons.Outlined

    optionsList.add(
        OptionsData(
            icon = appIcons.Person,
            title = "Account",
            subTitle = "Manage your account"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.ShoppingCart,
            title = "Orders",
            subTitle = "Orders history"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.Settings,
            title = "Addresses",
            subTitle = "Your saved addresses"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.Person,
            title = "Saved Cards",
            subTitle = "Your saved debit/credit cards"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.Settings,
            title = "Settings",
            subTitle = "App notification settings"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.Home,
            title = "Help Center",
            subTitle = "FAQs and customer support"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.ArrowBack,
            title = "Offers and Coupons",
            subTitle = "Offers and coupon codes for you"
        )
    )

    optionsList.add(
        OptionsData(
            icon = appIcons.FavoriteBorder,
            title = "Wishlist",
            subTitle = "Items you saved"
        )
    )
}

data class OptionsData(val icon: ImageVector, val title: String, val subTitle: String)