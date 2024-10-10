package com.example.convidados.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.convidados.constants.DataBaseConstants

// TODO - BANCO de DADOS -- UNICA FUNÇÂO CONEXÂO COM O BD
class GuestDataBase(context: Context)
    : SQLiteOpenHelper(context, NAME, null, VERSION) {

    companion object{
        private const val NAME = "guestdb"
        private const val VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        // TODO - CRIAÇÂO DO BANCO -- Estrutura da tabela (NÂO É PADRÂO)
        db.execSQL("create table" + DataBaseConstants.GUEST.TABLE_NAME + " ("+
                DataBaseConstants.GUEST.COLUMNS.ID +" integer primary key autoincrement, "+
                DataBaseConstants.GUEST.COLUMNS.NAME +" text,"+
                DataBaseConstants.GUEST.COLUMNS.PRESENCE +" interger);")

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

    }
}