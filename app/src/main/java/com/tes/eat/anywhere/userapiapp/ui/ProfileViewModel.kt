package com.tes.eat.anywhere.userapiapp.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel


class ProfileViewModel(
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val userId = savedStateHandle.get<Int>("id")

}

