package com.tes.eat.anywhere.userapiapp.ui

import androidx.compose.runtime.Composable

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.tes.eat.anywhere.userapiapp.R
import com.tes.eat.anywhere.userapiapp.model.data.remote.peopleresponse.PeopleItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@Composable
fun ProfileScreen(userName: String, id: String, img:String, navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top appbar
        TopAppbarProfile(
            context = LocalContext.current.applicationContext,
            navController = navController,
            )
        ProfileDetail(
            username = userName,
            id = id,
            img=img,
            context = LocalContext.current.applicationContext
        )
    }
}


@Composable
fun TopAppbarProfile(context: Context, navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        backgroundColor = MaterialTheme.colors.secondary,
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
fun ProfileDetail(
    username: String,
    id: String,
    img:String,
    context: Context = LocalContext.current.applicationContext
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .shadow(shape = RectangleShape, ambientColor = Color.Gray, elevation = 4.dp)
            .background(Color.LightGray)
    ) {
        UserDetails(context = context, username=username, id = id, img=img)
    }
}

// This composable displays user's image, name, email and edit button
@Composable
private fun UserDetails(context: Context, username: String, id: String, img:String) {
   // val imagePainter = rememberAsyncImagePainter(R.drawable.person)
    val imagePainter = rememberAsyncImagePainter(img)

    val icon = rememberAsyncImagePainter(R.drawable.github)

    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .shadow(shape = RectangleShape, elevation = 2.dp, ambientColor = Color.Cyan)
            .background(Color.Cyan)
    )
    {
        Column(

        ) {


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
                            text = "Login :$username",


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
                            text = "ID: $id",
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
                            Toast.makeText(context, "Edit Button", Toast.LENGTH_SHORT)
                                .show()
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

    }

    Text(
        text = "Posts: Three posts this month",
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .padding(20.dp),
        textAlign = TextAlign.Center

    )
    Text(
        text = "Follows: You followed 10 people ",
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .padding(20.dp),
        textAlign = TextAlign.Center
    )

    Text(
        text = "Repository: you have 103 repos",
        style = MaterialTheme.typography.body1,
        modifier = Modifier
            .padding(20.dp),
        textAlign = TextAlign.Center
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(30.dp)
                .clip(shape = CircleShape),
            painter = icon,
            contentDescription = ""
        )

        Text(
            text = "likes    " +
                    "Follows    " +
                    "Star    " +
                    "Settings",

            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(20.dp),
            textAlign = TextAlign.Center

        )
    }

}
