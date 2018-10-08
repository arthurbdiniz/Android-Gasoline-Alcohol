package com.example.arthurbdiniz.android_gasoline_alcohol

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var editTextGasolina: EditText? = null
    private var editTextAlcool: EditText? = null

    private var buttonCalculate: Button? = null

    private var precoGasolina: Double? = null
    private var precoAlcool: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextGasolina = findViewById(R.id.editTextGasolina)
        editTextAlcool = findViewById(R.id.editTextAlcool)

        buttonCalculate = findViewById(R.id.buttonCalculate)

        buttonCalculate!!.setOnClickListener(View.OnClickListener {
            val textGasolina = editTextGasolina!!.text.toString()
            val textAlcool = editTextAlcool!!.text.toString()

            if (textGasolina == "") {
                editTextGasolina!!.error = "Complete o campo gasolina antes de continuar"
                return@OnClickListener
            }
            if (textAlcool == "") {
                editTextAlcool!!.error = "Complete o campo alcool antes de continuar"
                return@OnClickListener
            }

            precoGasolina = java.lang.Double.valueOf(textGasolina)
            precoAlcool = java.lang.Double.valueOf(textAlcool)

            Log.d("MainActivity", precoGasolina!!.toString() + "  " + precoAlcool!!.toString())

            if (precoGasolina!! * 0.7 <= precoAlcool!!) {
                Toast.makeText(applicationContext, "Use Gasolina", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Use Alcool", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
