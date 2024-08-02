package com.example.myproyectopruebamvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.ViewGroup
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.myproyectopruebamvvm.R
import com.example.myproyectopruebamvvm.databinding.ActivityCharacterDetailsBinding
import com.example.myproyectopruebamvvm.ui.viewmodel.CharacterDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

/*dagger hilt*/
@AndroidEntryPoint
class CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharacterDetailsBinding

    private val characterDetailsViewModel: CharacterDetailsViewModel by viewModels()
    private var idCharacter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //responsive adaptative cardview Content
        responsiSizeCardViewDetails()

        idCharacter =  intent.getIntExtra("idCharacter",0)
        println("IDDDDDDDD"+idCharacter)
        binding.ivReturnCharacterDetails.setOnClickListener {
            onBackPressed()
            finish()
        }
        characterDetailsViewModel.onCreate(idCharacter)

        characterDetailsViewModel.characterDetailModel.observe(this) { character ->

            Glide.with(this).load(character.image).into(binding.ivProfilleCharacterCharacterDetail)//imagen de perfil
            binding.tvNameCharacterCharacterCharacterDetail.text = character.name
            binding.tvSpecie2CharacterCharacterDetail.text = character.species
            binding.tvStatus2CharacterCharacterDetail.text = character.status
            binding.tvGender2CharacterCharacterDetail.text = character.gender
            binding.tvOrigin2CharacterCharacterDetail.text = character.origin.name
            binding.ivLocation2CharacterCharacterDetail.text = character.location.name
            //Glide.with(this).load(character.location.url).into(binding.ivLocation2CharacterCharacterDetail)


        }

    }

    private fun responsiSizeCardViewDetails () {

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)

        val screenWidth = displayMetrics.widthPixels
        val screenHeight = displayMetrics.heightPixels

        val startMargin = (screenWidth * 0.1).toInt() // 10% del ancho de la pantalla
        val topMargin = (screenHeight * 0.1).toInt() // 20% del alto de la pantalla
        val endMargin = (screenWidth * 0.1).toInt() // 10% del ancho de la pantalla
        val bottomMargin = (screenHeight * 0.2).toInt() // 20% del alto de la pantalla

        val layoutParams = binding.cvContentDetail.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.setMargins(startMargin, topMargin, endMargin, bottomMargin)
        binding.cvContentDetail.layoutParams = layoutParams

    }

}