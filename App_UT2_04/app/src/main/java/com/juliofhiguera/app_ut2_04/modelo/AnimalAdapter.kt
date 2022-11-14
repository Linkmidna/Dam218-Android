package com.juliofhiguera.app_ut2_04.modelo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juliofhiguera.app_ut2_04.Animal
import com.juliofhiguera.app_ut2_04.R
import com.juliofhiguera.app_ut2_04.datos.DatosAnimales

class AnimalAdapter (private val onClickAdapter: (Animal) -> Unit) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>()
{
    private val listaAnimales = DatosAnimales.getDatosAnimales()

    class AnimalViewHolder(view : View, private val onClickHolder: (Int) -> Unit) : RecyclerView.ViewHolder(view)
    {
        val textViewNombreAnimal = view.findViewById<TextView>(R.id.textViewNombreAnimal)
        val imageViewAnimal = view.findViewById<ImageView>(R.id.imageViewAnimal)

        init{
            view.setOnClickListener{onClickHolder(adapterPosition)}
        }
    }

    fun addAnimal(animal:String){
        listaAnimales.add(Animal(animal, R.drawable.desconocido, ""))
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(adapterLayout){posicion -> onClickAdapter(listaAnimales[posicion])}
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val animal = listaAnimales[position]
        holder.textViewNombreAnimal.text = animal.nombre
        holder.imageViewAnimal.setImageResource(animal.imagenId)
    }

    override fun getItemCount(): Int = listaAnimales.size


}