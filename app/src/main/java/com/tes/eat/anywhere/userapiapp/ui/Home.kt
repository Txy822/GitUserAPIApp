package com.tes.eat.anywhere.userapiapp.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.tes.eat.anywhere.userapiapp.R
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User

// Step: Home screen - Scrolling
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
            Home()
        Spacer(Modifier.height(16.dp))



    }
}

@Composable
fun  Home() {
    val homeViewModel = viewModel(modelClass = ViewModel::class.java)
    val state by homeViewModel.stateTT

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

            items(state) { user: PeopleItem ->
                UserImageCard(user = user)
            }
        }
}

@Composable
fun UserImageCard(user:PeopleItem){
    val imagePainter = rememberAsyncImagePainter(user.avatarModel)

    Card(shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(16.dp)

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
                text = user.firstNameModel,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.paddingFromBaseline(
                    top = 24.dp, bottom = 8.dp
                )
            )
        }
        /*
        Box{
            Image(painter =imagePainter,
                contentDescription = null,
                modifier = Modifier
                    .size(88.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Surface(color = MaterialTheme.colors.onSurface.copy(alpha = .3f),
                modifier = Modifier.align(Alignment.BottomCenter),
                contentColor = MaterialTheme.colors.onSurface

            ) {
                Column(
                    modifier = Modifier
                        .size(44.dp)
                        .padding(4.dp)
                    ) {
                    Text(text = "Real name: ${user.firstNameModel}")
                    Text(text = "Id: ${user.idModel}",
                        style = MaterialTheme.typography.h3,
                        modifier = Modifier.paddingFromBaseline(
                            top = 24.dp, bottom = 8.dp
                        )
                    )

                    }
                }
            }
        */
        }
}


// Step: Align your body - Alignment
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.h3,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
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



