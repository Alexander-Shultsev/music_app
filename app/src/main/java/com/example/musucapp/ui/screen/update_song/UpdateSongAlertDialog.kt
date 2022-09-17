package com.example.musucapp.ui.screen.update_song

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.musucapp.R
import com.example.musucapp.context
import com.example.musucapp.model.Photo
import com.example.musucapp.ui.base.ButtonLittle
import com.example.musucapp.ui.base.H1
import com.example.musucapp.ui.base.H3
import com.example.musucapp.ui.base.TextFieldDark
import com.example.musucapp.ui.navigation.NavItems

@Composable
fun UpdateSongAlertDialog(
    photo: Photo,
    closeDialog: () -> Unit,
    viewModel: UpdateSongViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val _imageUri: MutableLiveData<Uri> = MutableLiveData()
    val _bitmap: MutableLiveData<Bitmap> = MutableLiveData()


    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()) {
            uri: Uri? -> _imageUri.postValue(uri)
        }

    _imageUri.value?.let {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(context.contentResolver, it)
            _bitmap.postValue(ImageDecoder.decodeBitmap(source))
        } else {
            _bitmap.postValue(
                MediaStore.Images.Media.getBitmap(
                    context.contentResolver, it
                )
            )
        }
    }

    AlertDialog(
        onDismissRequest = {  },
        title = { H1(title = "Update ${photo.title.split(" "[0])} song", color = Color.Black) },
        text = {
            Column {
                if (_bitmap.value != null) {
                    Image(
                        bitmap = _bitmap.value!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                launcher.launch("image/*")
                            }
                            .size(300.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                launcher.launch("image/*")
                            }
                            .size(300.dp)
                    )
                }
                TextFieldDark("Name song", onTextChange = { viewModel.setNameSongName(it) })
                TextFieldDark("Singer", onTextChange = { viewModel.setSingerName(it) })
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