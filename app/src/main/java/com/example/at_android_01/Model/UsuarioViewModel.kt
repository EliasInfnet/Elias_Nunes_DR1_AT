package com.example.at_android_01.Model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.Serializable

class UsuarioViewModel : ViewModel(),Serializable {
    var usuario : MutableLiveData<Usuario>? = null
}