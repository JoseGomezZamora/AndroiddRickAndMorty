package com.example.myproyectopruebamvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.myproyectopruebamvvm.databinding.ActivityMainBinding
import com.example.myproyectopruebamvvm.ui.view.CharactersListActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear un objeto Handler
        val handler = Handler()

        // Definir el tiempo de retraso en milisegundos (3 segundos = 3000 ms)
        val delayMillis = 3000L

        // Crear un Runnable que se ejecutará después del retraso
        val runnable = Runnable {
            // Crear el Intent que deseas ejecutar
            val intent = Intent(this@MainActivity, CharactersListActivity::class.java)
            startActivity(intent)
            finish() // Opcional: finalizar la actividad actual si no deseas volver a ella
        }

        // Ejecutar el Runnable después del retraso especificado
        handler.postDelayed(runnable, delayMillis)

    }
}