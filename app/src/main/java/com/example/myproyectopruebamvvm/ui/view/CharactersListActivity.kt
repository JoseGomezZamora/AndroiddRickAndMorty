package com.example.myproyectopruebamvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myproyectopruebamvvm.data.adapters.CharactersListAdapter
import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.databinding.ActivityCharactersListBinding
import com.example.myproyectopruebamvvm.ui.viewmodel.CharactersListViewModel
import dagger.hilt.android.AndroidEntryPoint

/*dagger hilt*/
@AndroidEntryPoint
class CharactersListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCharactersListBinding
    private lateinit var charactersListAdapter: CharactersListAdapter

    private val charactersListViewModel: CharactersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharactersListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        charactersListViewModel.onCreate()

        println("ANTES DEL VIEWMODEL")
        charactersListViewModel.charactersModel.observe(this) {
            rvCharacterList(it as ArrayList<CharactersModel>)
        }

        binding.svSearchListCharactersListActivity.setOnQueryTextListener( object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                println(newText)
                charactersListAdapter.filter(newText)
                return true
            }

        })

        println("FUERA DEL VIEWMODEL")

    }

    private fun rvCharacterList (lista: ArrayList<CharactersModel>) {

        charactersListAdapter = CharactersListAdapter(lista)
        binding.rvCharacterList.adapter = charactersListAdapter
        binding.rvCharacterList.layoutManager = LinearLayoutManager(this)


    }

}