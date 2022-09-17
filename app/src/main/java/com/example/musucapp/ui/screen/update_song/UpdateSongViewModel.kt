package com.example.musucapp.ui.screen.sign_in

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musucapp.lifecycleOwner
import com.example.musucapp.model.Post
import com.example.musucapp.model.service
import com.example.musucapp.ui.navigation.NavItems
import com.example.musucapp.ui.navigation.navigateTo
import kotlinx.coroutines.launch

class UpdateSongViewModel: ViewModel() {

    private val _nameSong: MutableLiveData<String> = MutableLiveData()
    private val _singer: MutableLiveData<String> = MutableLiveData()

    val nameSong: LiveData<String> = _nameSong
    val singer: LiveData<String> = _singer
//    val imageUri: LiveData<Uri> = _imageUri
//    val bitmap: LiveData<Bitmap> = _bitmap

    fun setNameSongName(text: String) {
        _nameSong.postValue(text)
    }

    fun setSingerName(text: String) {
        _singer.postValue(text)
    }

    fun updateData() {

    }
}