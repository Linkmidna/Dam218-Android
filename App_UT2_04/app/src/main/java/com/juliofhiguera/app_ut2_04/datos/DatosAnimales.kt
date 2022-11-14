package com.juliofhiguera.app_ut2_04.datos

import com.juliofhiguera.app_ut2_04.Animal
import com.juliofhiguera.app_ut2_04.R

object DatosAnimales {
    fun getDatosAnimales(): ArrayList<Animal>
    {
        return arrayListOf<Animal>(
            Animal("Ballena", R.drawable.ballena,"Pues una ballena"),
            Animal("Bisonte", R.drawable.bisonte,"Pues un bisonte"),
            Animal("Camaleon",R.drawable.camaleon, "Pues un camaleon"),
            Animal("Cebra",R.drawable.cebra, "Pues una cebra"),
            Animal("Cocodrilo",R.drawable.cocodrilo,"Pues un cocodrilo"),
            Animal("Elefante",R.drawable.elefante, "Pues un elefante"),
            Animal("Hipopotamo",R.drawable.hipopotamo, "Pues un hipopotamo"),
            Animal("Jirafa", R.drawable.jirafa, "Pues una jirafa"),
            Animal("Mono", R.drawable.mono, "Pues un mono"),
            Animal("Venado", R.drawable.venado, "Pues un venado"),
            Animal("Zoro",R.drawable.zorro, "Pues un zorro")
        )
    }

}