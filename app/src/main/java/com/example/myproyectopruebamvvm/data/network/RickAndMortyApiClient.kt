package com.example.myproyectopruebamvvm.data.network

import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.data.model.ResultsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RickAndMortyApiClient {

    @GET("character")
    suspend fun getAllCharacters(): Response<ResultsModel>

    @GET("character/{id}")
    suspend fun getCharacterId(@Path("id") characterId: Int): Response<CharactersModel>

}