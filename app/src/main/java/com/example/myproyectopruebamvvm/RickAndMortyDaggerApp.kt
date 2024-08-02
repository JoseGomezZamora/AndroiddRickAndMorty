package com.example.myproyectopruebamvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*CREE ESTA CLASE PARA DAGGER HILT
* AHORA EN EL MANIFFEST AGREGO UN NUEVO ATRIBUTTO
* QUE ES: android:name=".RickAndMortyDaggerApp"*/
@HiltAndroidApp
class RickAndMortyDaggerApp: Application()