package com.JulioFHiguera.app_ut2_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    private val datos = linkedMapOf<String, Int>(
        "Pedro" to R.drawable.avatar3,
        "Santiago" to R.drawable.avatar4,
        "Eva" to R.drawable.avatar2,
        "Maria" to R.drawable.avatar1
    )
    private var contador = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.button2)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val textView = findViewById<TextView>(R.id.textView)
        boton.setOnClickListener{
            cambiarImagenYTexto(textView,imageView)
        }
    }

    private fun cambiarImagenYTexto(textView: TextView,imageView: ImageView){
        contador++
        if (contador>=datos.size)contador=0
        val texto=datos.keys.elementAt(contador)
        textView.text=texto
        imageView.setImageResource(datos[texto]!!)
    }
}