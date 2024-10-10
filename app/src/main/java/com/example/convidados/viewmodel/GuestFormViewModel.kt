package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

// TODO - função transitar dados entre class mais usada (INSERÇÂO e RECUPERAÇÂO DO BANCO DE DADOS)
class GuestFormViewModel(application: Application): AndroidViewModel(application) {

    // TODO - Forma de inserçao de dados, INTANCIA!
    private val repository = GuestRepository.getInstance(application)

    //TODO - Parametro de modelo
    fun insert(guets: GuestModel){
        //TODO - Função vem do GuestRepository
        repository.insert(guets)
    }

}