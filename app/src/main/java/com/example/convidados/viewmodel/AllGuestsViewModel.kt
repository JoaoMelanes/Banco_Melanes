package com.example.convidados.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.model.GuestModel
import com.example.convidados.repository.GuestRepository

class AllGuestsViewModel(application: Application) : AndroidViewModel(application) {

    //TODO - INSTANCIA do repositorio
    private val repository = GuestRepository.getInstance(application.applicationContext)

    //TODO - Observador
    private val _listAllGuests = MutableLiveData<List<GuestModel>>()
    val guests: LiveData<List<GuestModel>> = _listAllGuests

    fun getAll() {
        //TODO - .value atribui o valor do paramentro
        _listAllGuests.value = repository.getAll()
    }
}