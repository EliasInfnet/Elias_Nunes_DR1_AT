package com.example.at_android_01.Fragments_Quiz

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.HandlerThread
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.at_android_01.Model.UsuarioViewModel

import com.example.at_android_01.R
import kotlinx.android.synthetic.main.fragment_q1.*
import kotlinx.coroutines.delay

/**
 * A simple [Fragment] subclass.
 */
class Q1Fragment : Fragment() {

    private lateinit var usuarioViewModel1 : UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_q1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let{
            usuarioViewModel1 = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }

        avanc_f1.setOnClickListener {
            if(edt_txt_f1.text.toString().toUpperCase() == "PLIERS" || edt_txt_f1.text.toString().toUpperCase() == "PLIER"){

                Toast.makeText(it.context,"Resposta correta",Toast.LENGTH_SHORT).show()

                usuarioViewModel1.usuario!!.value!!.pontuacao++



                object : CountDownTimer(5000,1000){

                    override fun onFinish() {

                        findNavController().navigate(R.id.q2Fragment)
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        if(millisUntilFinished/1000 <= 2){
                            Toast.makeText(it.context,(millisUntilFinished/1000 + 1).toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }.start()

            }

            else{
                Toast.makeText(it.context,"Resposta errada",Toast.LENGTH_SHORT).show()
            }
        }

        resp_f1.setOnClickListener {

            edt_txt_f1.setText("pliers")

            Toast.makeText(it.context,"Questao anulada",Toast.LENGTH_LONG).show()

                object : CountDownTimer(5000,1000){

                    override fun onFinish() {

                        findNavController().navigate(R.id.q2Fragment)
                    }

                    override fun onTick(millisUntilFinished: Long) {
                        if(millisUntilFinished/1000 <= 2){
                            Toast.makeText(it.context,(millisUntilFinished/1000 + 1).toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }.start()
        }
    }
}
