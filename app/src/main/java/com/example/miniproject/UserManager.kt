package com.example.miniproject

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {
    private val dataStore : DataStore<Preferences> = context.createDataStore(name = "user_prefs")

    companion object{
        val NAMA = preferencesKey<String>("USER_NAMA")
        val UMUR = preferencesKey<Int>("USER_UMUR")
        val EMAIL = preferencesKey<String>("USER_EMAIL")
        val PASSWORD = preferencesKey<String>("USER_PASS")
    } //simpan datanya jadi objek

    suspend fun saveData(nama : String, umur : Int, email : String, password : String){
        dataStore.edit {
            it[NAMA] = nama
            it[UMUR] = umur
            it[EMAIL] = email
            it[PASSWORD] = password
        }
    } //function untuk storing datanya



    val userNama : Flow<String> = dataStore.data.map {
        it[NAMA] ?: ""
    }

    val userUmur : Flow<Int> = dataStore.data.map {
        it[UMUR] ?: 0
    }

    val userEmail : Flow<String> = dataStore.data.map {
        it[EMAIL] ?: ""
    }

    val userPass : Flow<String> = dataStore.data.map {
        it[PASSWORD] ?: ""
    }

    suspend fun clearData(){
        dataStore.edit {
            it.clear()
        }
    }
}