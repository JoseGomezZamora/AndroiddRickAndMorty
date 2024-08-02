package com.example.myproyectopruebamvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//DaggerHilt
@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(private val getCharactersUseCase: GetCharactersUseCase): ViewModel() {

    val characterDetailModel = MutableLiveData<CharactersModel>()

    fun onCreate(idCharacter: Int) {

        viewModelScope.launch {

            println("IDDDD"+idCharacter)
            val result = getCharactersUseCase.getCharacterId(idCharacter)

            if (!result.id.equals("") || result.id != null){
                characterDetailModel.postValue(result)
            }

        }

    }

}