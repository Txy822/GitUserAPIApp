package com.tes.eat.anywhere.userapiapp.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.tes.eat.anywhere.userapiapp.BuildConfig
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    private val VALID_TOKEN:String = BuildConfig.TOKEN
    private val _personState: MutableState<List<Data>> = mutableStateOf(emptyList())
    val personState: MutableState<List<Data>>
        get() = _personState

    private val _userState: MutableState<List<User>> = mutableStateOf(emptyList())
    val userState: MutableState<List<User>>
        get() = _userState

    init {
        CoroutineScope(Dispatchers.Main).launch {

            try {
                val users = repository.getUsers("token $VALID_TOKEN")
                _userState.value = users
                Log.i("Tag", "Data Fetched")
            } catch (e: IOException) {
                Log.i("Tag", "Fetchich data problem")
                e.printStackTrace();
            }

        }
    }
}
