package com.example.musucapp.ui.screen.my_songs

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.example.musucapp.model.Song
import com.example.musucapp.model.service
import com.example.musucapp.ui.screen.sign_in.alertDialogViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MySongsViewModel: ViewModel() {

    private val _photos: MutableLiveData<ArrayList<Song>> = MutableLiveData()
    private val _isOpenAddSong: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isOpenUpdateSong: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _isOpenEditSong: MutableLiveData<Boolean> = MutableLiveData(false)
    private val _selectedTabNumber: MutableLiveData<Int> = MutableLiveData()
    private val _currentMusic: MutableLiveData<Int> = MutableLiveData()

    var nameTabs = arrayListOf("My", "Collab")

    val songs: LiveData<ArrayList<Song>> = _photos
    val isOpenAddSong: LiveData<Boolean> = _isOpenAddSong
    val isOpenUpdateSong: LiveData<Boolean> = _isOpenUpdateSong
    val isOpenEditSong: LiveData<Boolean> = _isOpenEditSong
    val selectedTabNumber: LiveData<Int> = _selectedTabNumber
    val currentSong: LiveData<Int> = _currentMusic

    init {
        getPhotos()
    }

    fun changeVisibleEditSongAlertDialog() {
        _isOpenEditSong.postValue(!isOpenEditSong.value!!)
    }

    fun changeVisibleUpdateSongAlertDialog() {
        _isOpenUpdateSong.postValue(!isOpenUpdateSong.value!!)
    }

    fun changeVisibleAddSongAlertDialog() {
        _isOpenAddSong.postValue(!isOpenAddSong.value!!)
    }

    private fun getPhotos() {
        viewModelScope.launch {
            try {
                _photos.postValue(service.getAllPhoto().body())
            } catch (e: Exception) {
                Log.e(TAG, "getPhotos: $e")
            }
        }
    }

    fun setTabSelected(value: Int) {
        _selectedTabNumber.postValue(value)
    }

    fun setCurrentMusic(value: Int) {
        _currentMusic.postValue(value)
    }

    fun showDialog(dialogID: String) {
        alertDialogViewModel.showDialog(dialogID)
    }

    fun deleteSong(currentSong: Int) {
        TODO("Not yet implemented")
    }
}