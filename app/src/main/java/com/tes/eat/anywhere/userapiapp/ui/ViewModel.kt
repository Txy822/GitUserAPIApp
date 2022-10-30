package com.tes.eat.anywhere.userapiapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tes.eat.anywhere.userapiapp.model.data.remote.people.PeopleItem
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.User
import com.tes.eat.anywhere.userapiapp.model.data.remote.userresponse.Users
import com.tes.eat.anywhere.userapiapp.model.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
        //fun getSearchUser(q: String) = LiveDataReactiveStreams.fromPublisher(userUseCase.getSearchUser(q))
        private val _state= MutableStateFlow(emptyList<User>())
    private val _stateTT:MutableState<List<PeopleItem>> = mutableStateOf(emptyList())


    private val _stateT:MutableState<List<User>> = mutableStateOf(emptyList())
        val stateT:MutableState<List<User>>
            get() =_stateT

    val stateTT:MutableState<List<PeopleItem>>
        get() =_stateTT

    val state:StateFlow<List<User>>
        //val stare:StateFlow<Users>

    get() = _state

    init{

        CoroutineScope(Dispatchers.Main).launch {
           // val searchUsers=repository.getSearches()
           // val users =repository.getUsers()
            val peopleItem =repository.getPeople()
//            _state.value=searchUsers
          //  _stateT.value=users
            _stateTT.value=peopleItem
        }
    }

}
