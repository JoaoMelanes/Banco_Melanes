package com.example.convidados.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel
import com.example.convidados.view.viewholder.GuestViewHolder

//TODO - Criação do adapter
class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    //TODO - criaçao de uma lista vazia
    private var guestList: List<GuestModel> = listOf()

    //TODO - faz a criação do layout.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {

        //TODO - Faz a conversão do layout para o layout criado no caso o row_guest
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item)
    }

    //TODO - faz a cola do layout e a lista.
    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(guestList[position])
    }

    //TODO - fala o tamnho da listagem, para que a recycleview consiga trabalha do jeito certo.
    override fun getItemCount(): Int {
        //TODO - faz a contagem do tamanho da lista
        return guestList.count()
    }

    //TODO - instancia da lista apartir do observer
    fun updateGuests(list: List<GuestModel>) {
        guestList = list
        //TODO - diz para a recycler atualizar as informações
        notifyDataSetChanged()
    }
}