package es.ivanlorenzo.ejemplointents

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity: AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.segunda)

        val intent = intent
        val nombre = intent.extras?.getString("nombre")

        val textViewNombre = findViewById<TextView>(R.id.textViewNombre)
        textViewNombre.text = nombre

        //Al pulsar el botón volvemos a la actividad principal
        val botonVolver = findViewById<Button>(R.id.buttonVolver)
        botonVolver.setOnClickListener {
            val intentDevuelto = Intent()
            intentDevuelto.putExtra("retorno", "Valor segunda pantalla")
            setResult(RESULT_OK, intentDevuelto)
            finish()
        }


    }

}