package com.tes.eat.anywhere.userapiapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.UserList
import com.tes.eat.anywhere.userapiapp.model.data.repository.DefaultUserRepository
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.util.*

import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
        //fun getSearchUser(q: String) = LiveDataReactiveStreams.fromPublisher(userUseCase.getSearchUser(q))
    private val _state= MutableStateFlow(emptyList<UserList>())
    //    val stare:StateFlow<List<UserList>>
    val stare:StateFlow<UserList>

    get() = _state


    init{
        viewModelScope.launch {
            val searchUsers=repository.getSearches()
            val users =repository.getUsers()
            _state.value=searchUsers
        }
    }

}
