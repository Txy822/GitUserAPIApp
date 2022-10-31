package com.tes.eat.anywhere.userapiapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

//    private val _personState:MutableState<List<PeopleItem>> = mutableStateOf(emptyList())
//    val personState:MutableState<List<PeopleItem>>
//        get() =_personState
//private val VALID_TOKEN="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"
    private val VALID_TOKEN="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"


    private val _personState: MutableState<List<Data>> = mutableStateOf(emptyList())
    val personState: MutableState<List<Data>>
        get() = _personState

    private val _userState: MutableState<List<User>> = mutableStateOf(emptyList())
    val userState: MutableState<List<User>>
        get() = _userState

    init {
        CoroutineScope(Dispatchers.Main).launch {
            val users = repository.getUsers("token $VALID_TOKEN")
            //val fakeData = repository.getData("2")
            //val fakeData =repository.getData()
           // _personState.value = fakeData.body()!!.data
            _userState.value=users
        }
    }

}
