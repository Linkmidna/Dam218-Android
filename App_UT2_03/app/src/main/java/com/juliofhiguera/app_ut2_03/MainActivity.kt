package com.juliofhiguera.app_ut2_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.text.DecimalFormat
import java.text.Format
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup = findViewById<RadioGroup>(R.id.opcionViaje)
        val textViewPrecioFinal = findViewById<TextView>(R.id.precio_final)
        val editTextPresupuesto = findViewById<EditText>(R.id.presupuesto)
        val switchIVA = findViewById<Switch>(R.id.switch_iva)
        val presupuesto : Double = 0.0

        radioGroup.setOnCheckedChangeListener { radioGroup, opc ->
            val precio : Double= calcularPrecio(opc,switchIVA.isChecked)

            if (!editTextPresupuesto.text.isEmpty()){
                val presupuesto : Double = editTextPresupuesto.text.toString().toDouble()
            }

            if (presupuesto >= precio){
                textViewPrecioFinal.setTextColor(getColor(R.color.verde))
            }
            else{
                textViewPrecioFinal.setTextColor(getColor(R.color.rojo))
            }
            textViewPrecioFinal.text = String.format("%.2f",precio)+" €"
        }
        switchIVA.setOnCheckedChangeListener { compoundButton, opc ->
            val precio = calcularPrecio(radioGroup.checkedRadioButtonId,opc)
            textViewPrecioFinal.text = String.format("%.2f",precio)+" €"
        }
    }

    private fun calcularPrecio(radioButtonId: Int, iva:Boolean) : Double
    {
        var precio : Double = when(radioButtonId)
        {
            R.id.opcion_peninsula -> 600.0
            R.id.opcion_islas -> 900.0
            else -> 520.0
        }
        if (iva){
            precio*=1.21
        }
        return precio

    }
}