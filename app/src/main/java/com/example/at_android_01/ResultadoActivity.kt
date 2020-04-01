package com.example.at_android_01

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.at_android_01.Model.Usuario
import com.example.at_android_01.Model.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlinx.android.synthetic.main.fragment_perfil.*

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var usuario1 = intent.getSerializableExtra("user_1") as Usuario

        var usuarioViewModel1 = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)

        usuarioViewModel1.usuario = MutableLiveData(usuario1)

        btn_nav.setupWithNavController(findNavController(R.id.fragment2))



    }




}
