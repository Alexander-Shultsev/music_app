package com.example.musucapp.ui.screen.update_song

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musucapp.context
import java.io.StringReader

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