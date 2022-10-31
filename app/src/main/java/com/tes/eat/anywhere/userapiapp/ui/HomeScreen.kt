package com.tes.eat.anywhere.userapiapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.tes.eat.anywhere.userapiapp.R
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(
    onClickItems: () -> Unit = {},
    modifier: Modifier = Modifier,
    homeUserViewModel:UserViewModel,
    state: List<User>,
    //state: List<Data>,
    //person:PeopleItem,
    navController: NavController
    ) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
            Home(homeUserViewModel,state,onClickItems,navController)
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
fun  Home(homeUserViewModel:UserViewModel, state: List<User>, onClickItems: () -> Unit = {},navController: NavController) {

//cab be changed to lazyrow
    LazyRow{
        if(state.isEmpty()) {
            item {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }
            items(state) { user: User ->
                UserImageCard(user = user, onClickItems)
            }
        }
}

@Composable
fun UserImageCard(user: User, onClickItems: () -> Unit = {} ){
    val imagePainter = rememberAsyncImagePainter(user.avatarUrl)

    Card(shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)
            .clickable {onClickItems.invoke()}
    ) {
        Column(
            modifier = Modifier,
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
                text = user.login,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(
                    top = 24.dp, bottom = 8.dp
                )
            )
        }
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



