package com.example.at_android_01.Fragments_Resultado

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.at_android_01.Model.UsuarioViewModel

import com.example.at_android_01.R
import kotlinx.android.synthetic.main.fragment_perfil.*

/**
 * A simple [Fragment] subclass.
 */
class PerfilFragment : Fragment() {

    private lateinit var usuarioViewModelR1 : UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let{
            usuarioViewModelR1 = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }

        var textoParabens = "Parabens ${usuarioViewModelR1.usuario!!.value!!.nome.toString()}, voce marcou:"

        txt_fr1.setText(textoParabens)
        txt_pr.setText(usuarioViewModelR1.usuario!!.value!!.pontuacao.toString())

        Comp_btn.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("email@email.com"))
                putExtra(Intent.EXTRA_SUBJECT, "Minha pontuacao foi de ${usuarioViewModelR1.usuario!!.value!!.pontuacao.toString()}")
            }

            startActivity(intent)
        }
    }
}
