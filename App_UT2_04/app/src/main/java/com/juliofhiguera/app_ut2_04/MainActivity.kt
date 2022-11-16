package com.juliofhiguera.app_ut2_04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.juliofhiguera.app_ut2_04.modelo.AnimalAdapter
import com.juliofhiguera.app_ut2_04.modelo.DetalleAnimalActivity

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = AnimalAdapter(){ animal -> onClickAnimal(animal)}
        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.addItemDecoration(
            DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL
            )
        )

        val botonAnadir = findViewById<FloatingActionButton>(R.id.boton_añadir)
        botonAnadir.setOnClickListener(){
            dialogoNuevoAnimal()
        }
    }
    private fun onClickAnimal(animal: Animal)
    {
        //Esto es para mostrar el mensaje chiquito
        //Toast.makeText(this, animal.descripcion, Toast.LENGTH_LONG).show()

        //Esto para el detallado
        //Si casca hay que modificar el AndroidManifest.xml en la carpeta manifest y poner el :
        // *Click derecho en clase, copy Path, copy reference* donde aparece el nombre de la clase
        // por si acaso cambiar tambien el true debajo
        val intent = Intent(applicationContext, DetalleAnimalActivity::class.java)
        intent.putExtra("animal",animal)
        startActivity(intent)
    }

    private fun dialogoNuevoAnimal()
    {
        val inputEditTextField = EditText(this)
        val dialog = MaterialAlertDialogBuilder(this)
            .setTitle("Nuevo animal")
            .setMessage("Introduce el nombre de un nuevo animal")
            .setView(inputEditTextField)
            .setPositiveButton("Añadir") { _, _ ->
                val nuevoAnimal = inputEditTextField .text.toString()
                (recyclerView.adapter as AnimalAdapter).addAnimal(nuevoAnimal)
            }
            .setNegativeButton("Cancelar", null)
            .create()
        dialog.show()
    }


}