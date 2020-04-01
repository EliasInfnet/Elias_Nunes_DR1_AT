package com.example.at_android_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.at_android_01.Model.Usuario
import com.example.at_android_01.Model.UsuarioViewModel
import kotlinx.android.synthetic.main.fragment_q1.*

class QuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        var usuario = intent.getSerializableExtra("user") as Usuario

        var usuarioViewModel = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)

        usuarioViewModel.usuario = MutableLiveData(usuario)

        usuarioViewModel.usuario!!.observe(this, Observer {
            Toast.makeText(this,"usuario atualizado",Toast.LENGTH_SHORT).show()
        })




    }
}
