package com.example.myproyectopruebamvvm.data.model

data class CharactersModel(val id: Int,
                           val name: String,
                           val status: String,
                           val species: String,
                           val type: String,
                           val gender: String,
                           val image: String,
                           val url: String,
                           val created: String,
                           val location: LocationModel,
                           val origin: OriginModel)
