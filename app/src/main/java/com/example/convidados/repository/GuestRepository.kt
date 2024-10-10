package com.example.convidados.repository

import android.content.ContentValues
import android.content.Context
import com.example.convidados.constants.DataBaseConstants
import com.example.convidados.model.GuestModel

//TODO - Unica função manipulação de dados
class GuestRepository private constructor(context: Context) {

    //TODO - Junção com o banco de dados, INTANCIA!
    private val guestDataBase = GuestDataBase(context)

    // TODO Singleton - Forma de instanciar um banco de dados. PADRÂO!
    companion object {
        private lateinit var repository: GuestRepository

        //TODO - Forma de evitar que o banco seja instanciado mais de uma vez. PADRÂO!
        fun getInstance(context: Context): GuestRepository {
            if (!Companion::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    /*TODO - GuetsModel o modelo,
       é possivel ser usados dentro do escopo das funções, para recuperação de valores.
    */
    /*
    TODO - parametro Boolean é inserido pois a função usa um return,
        é preciso informar oque retorna seja (BOOlEAN, STRING, INT...).
     */

    //TODO - list usado porque retorna nossa lista de convidados - CODIGO ULTILIZADO POR PADRÂO
    fun getAll(): List<GuestModel> {
        val list = mutableListOf<GuestModel>()
        val db = guestDataBase.writableDatabase
        try {
            //TODO - Define a lista de dados que eu quero que me retorne.
            val projection = arrayOf(
                DataBaseConstants.GUEST.COLUMNS.ID,
                DataBaseConstants.GUEST.COLUMNS.NAME,
                DataBaseConstants.GUEST.COLUMNS.PRESENCE
            )
            //TODO - Query retorna os dados da tabela.
            val cursor = db.query(
                DataBaseConstants.GUEST.TABLE_NAME, projection,
                null, null, null, null, null
            )
            //TODO - faz com que seja retornado as listas dentro da tabela
            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    /*TODO - Define qual o index da coluna que ele irá ler
                   (DE ACORDO COM A LISTA A CIMA "seleciton" ^^^^)
                */
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    // TODO - adiciona novas pessoas a nossa lista de presença
                    list.add(GuestModel(id, name, presence == 1))
                }
            }
            //TODO - OBRIGATORIO SER FECHADO
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }

    fun insert(guest: GuestModel): Boolean {
        return try {
            //TODO - faz a inserção de dados -- PADRÂO
            val db = guestDataBase.writableDatabase

            //TODO - apenas se o modelo for um booleano, para ter 100% de certeza que vai funcionar
            val presence = if (guest.presence) 1 else 0

            //TODO - função de atribução de valores a coluna do BD
            val values = ContentValues()
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            //TODO - insert função PADRÂO de inserção
            db.insert(DataBaseConstants.GUEST.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }

    }

    fun update(guest: GuestModel): Boolean {
        return try {
            val db = guestDataBase.writableDatabase
            val presence = if (guest.presence) 1 else 0

            val values = ContentValues()
            values.put(DataBaseConstants.GUEST.COLUMNS.NAME, guest.name)
            values.put(DataBaseConstants.GUEST.COLUMNS.PRESENCE, presence)

            //TODO - faz a atualização onde o id de selection for igual ao args
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            db.update(DataBaseConstants.GUEST.TABLE_NAME, values, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            val db = guestDataBase.writableDatabase

            //TODO - faz a atualização onde o id de selection for igual ao args
            val selection = DataBaseConstants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            db.delete(DataBaseConstants.GUEST.TABLE_NAME, selection, args)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getPresent(): List<GuestModel> {
        val list = mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.writableDatabase
            //TODO - Query retorna os dados da tabela.
            val cursor = db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 1",null)

            //TODO - faz com que seja retornado as listas dentro da tabela
            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    /*TODO - Define qual o index da coluna que ele irá ler
                   (DE ACORDO COM A LISTA A CIMA "seleciton" ^^^^)
                */
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    // TODO - adiciona novas pessoas a nossa lista de presença
                    list.add(GuestModel(id, name, presence == 1))
                }
            }
            //TODO - OBRIGATORIO SER FECHADO
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }

    fun getAbsente(): List<GuestModel> {
        val list = mutableListOf<GuestModel>()

        try {
            val db = guestDataBase.writableDatabase
            //TODO - Query retorna os dados da tabela.
            val cursor = db.rawQuery("SELECT id, name, presence FROM Guest WHERE presence = 0",null)

            //TODO - faz com que seja retornado as listas dentro da tabela
            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {

                    /*TODO - Define qual o index da coluna que ele irá ler
                   (DE ACORDO COM A LISTA A CIMA "seleciton" ^^^^)
                */
                    val id =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.ID))
                    val name =
                        cursor.getString(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.NAME))
                    val presence =
                        cursor.getInt(cursor.getColumnIndex(DataBaseConstants.GUEST.COLUMNS.PRESENCE))

                    // TODO - adiciona novas pessoas a nossa lista de presença
                    list.add(GuestModel(id, name, presence == 1))
                }
            }
            //TODO - OBRIGATORIO SER FECHADO
            cursor.close()
        } catch (e: Exception) {
            return list
        }
        return list
    }


}