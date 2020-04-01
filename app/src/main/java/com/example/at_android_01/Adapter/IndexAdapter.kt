package com.example.at_android_01.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.RecyclerView
import com.example.at_android_01.Model.Usuario
import com.example.at_android_01.R
import kotlinx.android.synthetic.main.fragment_index.*
import kotlinx.android.synthetic.main.recycle_result_layout.view.*

class IndexAdapter(
    val usuarios : List<Usuario>
) : RecyclerView.Adapter<IndexAdapter.IndexViewHolder>(){

    class IndexViewHolder(view : View) : RecyclerView.ViewHolder(view){

        val txtVnome = view.nome_recycle_txt
        val txtVemail = view.email_recycle_txt
        val txtVpontuacao = view.pontuacao_recycle_txt

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndexViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(
            R.layout.recycle_result_layout,parent,false
        )

        val indexViewHolder = IndexViewHolder(view)

        return indexViewHolder
    }

    override fun getItemCount(): Int = usuarios.size

    override fun onBindViewHolder(holder: IndexViewHolder, position: Int) {
        val usuario = usuarios[position]
        holder.txtVnome.text = usuario.nome
        holder.txtVemail.text = usuario.email
        holder.txtVpontuacao.text = usuario.pontuacao.toString()

    }
}