package com.example.convidados.constants


//TODO - private constructor não permite que seja instanciada a classe
class DataBaseConstants private constructor(){

    //TODO - OBJECT permite ser vista de qualquer classe mesmo com o contrutor privado
    object GUEST{
        const val TABLE_NAME = "Guest"

        object COLUMNS{
            const val ID = "id"
            const val NAME = "name"
            const val PRESENCE = "presence"
        }
    }
}
