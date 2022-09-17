package com.example.musucapp.ui.screen.update_song

import android.content.ContentValues.TAG
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.musucapp.R
import com.example.musucapp.context
import com.example.musucapp.model.Song
import com.example.musucapp.ui.base.ButtonLittle
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.base.TextFieldDark
import com.example.musucapp.ui.screen.sign_in.UpdateSongViewModel


@Composable
fun UpdateSongAlertDialog(
    checkSong: Song?,
    closeDialog: () -> Unit,
    viewModel: UpdateSongViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val _imageUri: MutableLiveData<Uri> = MutableLiveData()
    val _bitmap: MutableLiveData<Bitmap> = MutableLiveData()

    val imageUri: LiveData<Uri> = _imageUri
    val bitmap: LiveData<Bitmap> = _bitmap

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        _imageUri.postValue(uri)
    }

    AlertDialog(
        onDismissRequest = {  },
        title = { H1(title = "Update ${checkSong?.title!!.split(" ")[0]} song", color = Color.Black) },
        text = {
            if (imageUri.value != null) {
                Log.i(TAG, "setBitmap")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    val source = ImageDecoder.createSource(context.contentResolver, imageUri.value!!)
                    _bitmap.postValue(ImageDecoder.decodeBitmap(source))
                } else {
                    _bitmap.postValue(
                        MediaStore.Images.Media.getBitmap(
                            context.contentResolver, imageUri.value
                        )
                    )
                }
            }

            if (bitmap.value == null) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            launcher.launch("image/*")
                        }
                        .size(300.dp)
                )
            } else {
                Image(
                    bitmap = _bitmap.value!!.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            launcher.launch("image/*")
                        }
                        .size(300.dp)
                )
            }
        },
        confirmButton = {
            ButtonLittle(
                onClick = {
                    closeDialog()
                    viewModel.updateData()
                },
                text = "Save",
            )
        }
    )
}