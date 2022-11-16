package com.juliofhiguera.app_ut2_04.modelo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.juliofhiguera.app_ut2_04.Animal
import com.juliofhiguera.app_ut2_04.R

class DetalleAnimalActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_animal)
        val animal = intent.extras?.get("animal") as Animal

        val imagen = findViewById<ImageView>(R.id.imagen)
        imagen.setImageResource(animal.imagenId)
        val nombre = findViewById<TextView>(R.id.nombre)
        nombre.text=animal.nombre
        val descripcion = findViewById<TextView>(R.id.descripcion)
        descripcion.text = animal.descripcion

    }
}