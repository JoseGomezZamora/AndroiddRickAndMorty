package com.example.myproyectopruebamvvm.data

import android.content.Context
import android.widget.Toast
import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.data.model.ResultsModel
import com.example.myproyectopruebamvvm.data.network.CharactersService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CharactersRepository @Inject constructor(
    private val api: CharactersService,
    @ApplicationContext private val cont: Context
    //private val charactersDao:
    ) {

    suspend fun getAllCharactersFromApi(): List<CharactersModel>{

        val response: List<CharactersModel> = api.getCharacters()
        return response

    }

    suspend fun getCharacterIdFromApi(id: Int): CharactersModel {

        val response: CharactersModel = api.getCharacterId(id)

        return response

    }

}