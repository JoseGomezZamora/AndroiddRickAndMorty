package com.example.myproyectopruebamvvm.di

import com.example.myproyectopruebamvvm.data.network.RickAndMortyApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//utilizara las etiquetas de DaggerHilt
@Module
@InstallIn(SingletonComponent::class)
object NetworkApiModule {

    //provveo a retrofit
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {

        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    //con daggerHilt
    @Singleton
    @Provides
    fun provideRickAndMortyApiClient(retrofit: Retrofit): RickAndMortyApiClient {

        return retrofit.create(RickAndMortyApiClient::class.java)

    }

}