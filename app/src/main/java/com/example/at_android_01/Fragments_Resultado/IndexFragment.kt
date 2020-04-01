package com.example.at_android_01.Fragments_Resultado

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.at_android_01.Adapter.IndexAdapter
import com.example.at_android_01.Model.Usuario
import com.example.at_android_01.Model.UsuarioViewModel

import com.example.at_android_01.R
import kotlinx.android.synthetic.main.fragment_index.*

/**
 * A simple [Fragment] subclass.
 */
class IndexFragment : Fragment() {

    private lateinit var usuarioViewModelR2 : UsuarioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_index, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let{
            usuarioViewModelR2 = ViewModelProviders.of(it).get(UsuarioViewModel::class.java)
        }

        var usuarios = mutableListOf(
            Usuario("roberto","roberto@gmail.com",9),
            Usuario("marcela","marcela@gmail.com",9),
            Usuario("leonardo","leo@gmail.com",8),
            Usuario("maria","maria@gmail.com",10),
            Usuario(
                usuarioViewModelR2.usuario!!.value!!.nome,
                usuarioViewModelR2.usuario!!.value!!.email,
                usuarioViewModelR2.usuario!!.value!!.pontuacao)
        )

        var indexAdapter = IndexAdapter(usuarios)
        recyclerView_Index.adapter = indexAdapter
        recyclerView_Index.layoutManager = LinearLayoutManager(context)
    }
}
