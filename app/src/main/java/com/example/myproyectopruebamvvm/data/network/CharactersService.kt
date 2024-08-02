package com.example.myproyectopruebamvvm.data.network

import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.data.model.LocationModel
import com.example.myproyectopruebamvvm.data.model.OriginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

//inyectando mi instancia de mi Interface de ApiClient retrofit con daggerHilt
class CharactersService @Inject constructor(private val api:RickAndMortyApiClient) {

    suspend fun getCharacters(): List<CharactersModel>{

        //con el withContext(Dispatchers.IO) ejecuto esta llamada en un hilo secundario
        return withContext(Dispatchers.IO){

            val response = api.getAllCharacters()//hago mi llamada ala api
            response.body()?.results

            //con el ?: le decimos que si es null entonces regrese una lista vacia
            response.body()?.results ?: emptyList()

        }

    }

    suspend fun getCharacterId(id: Int): CharactersModel {

        //con el withContext(Dispatchers.IO) ejecuto esta llamada en un hilo secundario
        return withContext(Dispatchers.IO){

            val response = api.getCharacterId(id)//hago mi llamada ala api
            response.body()

            //con el ?: le decimos que si es null entonces regrese una lista vacia
            response.body() ?: CharactersModel(0, "", "", "", "", "", "", "", "", LocationModel("",""),
                OriginModel("","")
            )

        }

    }

}