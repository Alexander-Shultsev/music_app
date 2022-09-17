package com.example.musucapp.ui.screen.edit_song

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musucapp.model.Song

class EditSongViewModel: ViewModel() {

    private val _editSong: MutableLiveData<Song> = MutableLiveData()
    val editSong: LiveData<Song> = _editSong

    fun setEditPhoto(song: Song) {
        _editSong.postValue(song)
    }
}