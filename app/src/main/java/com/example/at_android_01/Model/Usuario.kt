package com.example.at_android_01.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.Serializable

class Usuario(var nome : String, var email : String, var pontuacao : Int) : Serializable