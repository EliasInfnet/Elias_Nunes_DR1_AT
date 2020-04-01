package com.example.at_android_01.Fragments_Quiz

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.at_android_01.Model.Usuario
import com.example.at_android_01.Model.UsuarioViewModel

import com.example.at_android_01.R
import com.example.at_android_01.ResultadoActivity
import kotlinx.android.synthetic.main.fragment_q9.*

/**
 * A simple [Fragment] subclass.
 */
class Q9Fragment : Fragment() {

    private lateinit var usuarioViewModel9 : UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q9, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let{
            usuarioViewModel9 = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }

        avanc_f9.setOnClickListener {
            if(edt_txt_f9.text.toString().toUpperCase() == "BEANIE"){

                Toast.makeText(it.context,"Resposta correta", Toast.LENGTH_SHORT).show()

                usuarioViewModel9.usuario!!.value!!.pontuacao++

                object : CountDownTimer(5000,1000){

                    override fun onFinish() {
                        var intent = Intent(activity!!.baseContext,ResultadoActivity::class.java)

                        var usuario = Usuario(
                            usuarioViewModel9.usuario!!.value!!.nome,
                            usuarioViewModel9.usuario!!.value!!.email,
                            usuarioViewModel9.usuario!!.value!!.pontuacao
                        )

                        intent.putExtra("user_1",usuario)
                        startActivity(intent)
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        if(millisUntilFinished/1000 <= 2){
                            Toast.makeText(it.context,(millisUntilFinished/1000 + 1).toString(),
                                Toast.LENGTH_SHORT).show()
                        }
                    }
                }.start()

            }

            else{
                Toast.makeText(it.context,"Resposta errada", Toast.LENGTH_SHORT).show()
            }
        }

        resp_f9.setOnClickListener {

            edt_txt_f9.setText("beanie")

            Toast.makeText(it.context,"Questao anulada", Toast.LENGTH_LONG).show()

            object : CountDownTimer(5000,1000){

                override fun onFinish() {
                    var intent = Intent(activity!!.baseContext,ResultadoActivity::class.java)

                    var usuario = Usuario(
                        usuarioViewModel9.usuario!!.value!!.nome,
                        usuarioViewModel9.usuario!!.value!!.email,
                        usuarioViewModel9.usuario!!.value!!.pontuacao
                    )

                    intent.putExtra("user_1",usuario)
                    startActivity(intent)
                }

                override fun onTick(millisUntilFinished: Long) {
                    if(millisUntilFinished/1000 <= 2){
                        Toast.makeText(it.context,(millisUntilFinished/1000 + 1).toString(),
                            Toast.LENGTH_SHORT).show()
                    }
                }
            }.start()
        }
    }
}
