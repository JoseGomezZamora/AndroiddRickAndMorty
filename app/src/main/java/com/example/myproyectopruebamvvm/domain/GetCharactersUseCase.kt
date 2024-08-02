package com.example.myproyectopruebamvvm.domain

import com.example.myproyectopruebamvvm.data.CharactersRepository
import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.data.model.ResultsModel
import javax.inject.Inject

/** CREADO POR ARMANDO 26/05/2023
 * AQUI VA LA LOGICA DE NEGOCIO
 * O LO QUE VA HACER CON LA INFORMACION*/
class GetCharactersUseCase @Inject constructor(private val repository: CharactersRepository) {

    /*aqui es operator fun invoke() por que como solo era una funcion , asi con solo instanciar se ejecutaba la funcion ahora como ya hay dos funciones tengo que nombrar las dos fun
    suspend operator fun invoke(): List<CharactersModel>{

        val character = repository.getAllCharactersFromApi()

        return character

    }*/

    suspend fun getAllCharcters(): List<CharactersModel>{

        val character = repository.getAllCharactersFromApi()

        return character

    }

    suspend fun getCharacterId(id: Int): CharactersModel{

        val character = repository.getCharacterIdFromApi(id)

        return character

    }

}