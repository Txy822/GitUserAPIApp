package com.tes.eat.anywhere.userapiapp.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.userapiapp.model.data.repository.StoredRepository


class ProfileViewModel(
    savedStateHandle: SavedStateHandle,
    userRepository: StoredRepository
) :
    ViewModel() {

    private val userId = savedStateHandle.get<Int>("id")
    val user = userRepository.getUser(userId)!!


}

