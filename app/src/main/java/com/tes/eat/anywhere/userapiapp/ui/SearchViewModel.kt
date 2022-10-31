package com.tes.eat.anywhere.userapiapp.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.userapiapp.model.data.remote.fake.Data
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.security.auth.callback.Callback


@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    private val _listUsers : MutableState<List<User>> = mutableStateOf(emptyList())
    val listUsers:MutableState<List<User>>
        get() =_listUsers

    init{
        CoroutineScope(Dispatchers.Main).launch {
            val users =repository.getSearches("tesf")
            _listUsers.value= users
        }
    }

    fun setSearchUsers(){
        CoroutineScope(Dispatchers.Main).launch {
            val users =repository.getSearches("tesf")
            listUsers.value= users
        }

    }
}



