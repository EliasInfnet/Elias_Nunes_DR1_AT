package com.example.at_android_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.at_android_01.Model.Usuario
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_iniciar.setOnClickListener {

            if(!nome_edt_txt.text.isEmpty() && !email_edt_txt.text.isEmpty()){

                var usuario = Usuario(nome_edt_txt.text.toString(),email_edt_txt.text.toString(),0)

                var intent = Intent(this,QuizActivity::class.java)

                intent.putExtra("user",usuario)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Entre com seu nome e senha",Toast.LENGTH_LONG).show()
            }
        }
    }
}
