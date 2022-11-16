package es.ivanlorenzo.ejemplointents

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class PrimeraActivity : AppCompatActivity()
{
    private val segundaActivityLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        {
            if(it.resultCode == Activity.RESULT_OK){
                val retorno = it.data?.getStringExtra("retorno")
                Toast.makeText(applicationContext, "El valor devuelto es $retorno",
                    Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.primera)

        val botonHomer = findViewById<Button>(R.id.buttonHomer)
        val editText = findViewById<EditText>(R.id.editTextNombre)
        botonHomer.setOnClickListener { abrirSegundaActivity(editText.text.toString()) }

        val botonIntentImplicito = findViewById<Button>(R.id.buttonIntentImplicito)
        botonIntentImplicito.setOnClickListener {
            //buscarInformacion("Homer Simpson")
            //llamarTelefono("666111222")
            //verMapa(Uri.parse("geo:43.352178,-4.062969?z=17"))
            abrirPaginaWeb("http://www.iesmiguelherrero.com")
        }
    }

    private fun abrirSegundaActivity(nombre: String)
    {
        val intent = Intent(applicationContext, SegundaActivity::class.java)
        intent.putExtra("nombre", nombre)
        segundaActivityLauncher.launch(intent)
    }


    private fun buscarInformacion(mensaje: String)
    {
        val intent = Intent(Intent.ACTION_WEB_SEARCH).apply {
            putExtra(SearchManager.QUERY, mensaje)
        }
        startActivity(intent)
    }

    private fun llamarTelefono(numero: String)
    {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$numero")
        }
        startActivity(intent)
    }

    private fun verMapa(geoLocalizacion: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = geoLocalizacion
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun abrirPaginaWeb(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        startActivity(intent)
    }
}