package com.example.myproyectopruebamvvm.data.adapters

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myproyectopruebamvvm.R
import com.example.myproyectopruebamvvm.data.model.CharactersModel
import com.example.myproyectopruebamvvm.ui.view.CharacterDetailsActivity
import java.util.*
import java.util.stream.Collectors
import kotlin.collections.ArrayList

class CharactersListAdapter (private val charactersModel: ArrayList<CharactersModel>):
    RecyclerView.Adapter<CharactersListAdapter.vh>() {

    private lateinit var cont: Context
    private var dataAux: ArrayList<CharactersModel> = ArrayList(charactersModel)//var aux

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): vh {
        cont = parent.context//contexto de mi actividad donde esta el contenedor fragment
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharactersListAdapter.vh(layoutInflater.inflate(R.layout.item_characters_list, parent, false))
    }

    override fun onBindViewHolder(holder: vh, position: Int) {

        //holder.imageView.setImageBitmap()
        Glide.with(cont).load(charactersModel[position].image).into(holder.imageView)
        holder.tvNameCharacter.text = charactersModel[position].name
        holder.tvSpecieCharacter.text = charactersModel[position].species
        holder.cvContetnItemCharactersList.setOnClickListener {

            val detail = Intent(cont, CharacterDetailsActivity::class.java)
            detail.putExtra("idCharacter", charactersModel[position].id)
            cont.startActivity(detail)

        }

    }

    override fun getItemCount(): Int = charactersModel.size

    class vh(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var cvContetnItemCharactersList = itemView.findViewById<CardView>(R.id.cvContetnItemCharactersList)
        var imageView = itemView.findViewById<ImageView>(R.id.imageView)
        var tvNameCharacter = itemView.findViewById<TextView>(R.id.tvNameCharacter)
        var tvSpecieCharacter = itemView.findViewById<TextView>(R.id.tvSpecieCharacter)
    }

    fun filter(query:String) {

        val longitud = query.length
        if (longitud == 0) {
            charactersModel.clear()
            charactersModel.addAll(dataAux!!)
        } else {
            val collection = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                charactersModel.stream()
                    .filter { i -> i.name.lowercase().contains(query.lowercase()) }
                    .collect(Collectors.toList())
            } else {
                val filteredList = java.util.ArrayList<CharactersModel>()
                for (c in charactersModel) {
                    if (c.name.lowercase().contains(query.lowercase())) {
                        filteredList.add(c)
                    }
                }
                filteredList
            }
            charactersModel.clear()
            charactersModel.addAll(collection)
        }
        notifyDataSetChanged()
    }
}