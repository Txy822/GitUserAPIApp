package com.tes.eat.anywhere.userapiapp.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tes.eat.anywhere.userapiapp.R
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.Users
import com.tes.eat.anywhere.userapiapp.ui.destinations.Profile

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    state: List<User>,
    navController: NavController
) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        Home(
            state,
            navController
        )

        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun Home(
    state: List<User>,
    navController: NavController
) {
    Users(users =state) { user ->
        navController.navigate(route = "${Profile.route}?login=${user.login} id=${user.id}")
    }
}

@Composable
fun Users(users: List<User>?, onClick: (User) -> Unit) {
    users?.forEach { user ->
        UserRow(user = user) {
            onClick(user)
        }
        Divider()
    }
}
@Composable
fun UserRow(user: User, onClick: () -> Unit) {
    val imagePainter = rememberAsyncImagePainter(user.avatarUrl)

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onClick() }
        .shadow(shape = CircleShape, elevation = 4.dp)
        .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = "${user.login}: Given ID ${user.id}",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.paddingFromBaseline(
                top = 20.dp, bottom = 8.dp
            ).shadow(shape = RectangleShape, elevation = 1.dp, spotColor = Color.Blue)
        )
    }
}

// Step: Search bar - Modifiers
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

