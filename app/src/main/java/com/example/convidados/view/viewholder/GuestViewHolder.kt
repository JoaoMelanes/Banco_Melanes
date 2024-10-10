package com.example.convidados.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.databinding.RowGuestBinding
import com.example.convidados.model.GuestModel

//TODO - Criação da view holder -- carrega as informções da view - RowGuestBinding é o layout criado.
class GuestViewHolder(private val bind: RowGuestBinding) : RecyclerView.ViewHolder(bind.root) {

    //TODO - atribui os valores de GuestModel
    fun bind(guest: GuestModel) {
        bind.textName.text = guest.name
    }
}