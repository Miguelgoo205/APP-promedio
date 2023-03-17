package com.example.calculatenotes

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var note1: EditText? = null
    var note2: EditText? = null
    var note3: EditText? = null
    var name: EditText? = null
    var subject: EditText? = null
    var result: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        note1 = findViewById(R.id.inputNote1)
        note2 = findViewById(R.id.inputNote2)
        note3 = findViewById(R.id.inputNote3)
        name = findViewById(R.id.inputName)
        subject = findViewById(R.id.inputSubject)
        result = findViewById(R.id.result)

        val btnCalculate: Button = findViewById(R.id.btnCal1)
        btnCalculate.setOnClickListener { onClick(1) }

        val miBoton2: Button = findViewById(R.id.btnCal2)
        miBoton2.setOnClickListener { onClick(2) }
    }


    fun onClick(btnCalculate: Int) {
        var subjectUser: String = subject!!.text.toString()
        var nameUser: String = name!!.text.toString()
        var uNote1: Float = note1!!.text.toString().toFloat()
        var uNote2: Float = note2!!.text.toString().toFloat()
        var uNote3: Float = note3!!.text.toString().toFloat()

        when (btnCalculate) {
            1 -> {
                if (uNote1 > 5 || uNote1 < 1 || uNote2 > 5 || uNote2 < 1 || uNote3 > 5 || uNote3 < 1) {
                    Toast.makeText(this, "Por favor ingrese notas dentro del rango del 1 al 5", Toast.LENGTH_LONG).show()

                } else {
                    val campoMessage = findViewById<TextView>(R.id.txtMensaje)
                    var average: Float = (uNote1 + uNote2 + uNote3) / 3
                    if (average!! >= 3.5){
                        campoMessage!!.text= "Felicidades $nameUser usted aprobo $subjectUser con un promedio de: $average"
                        campoMessage!!.setTextColor(Color.GREEN)

                    }
                    else{
                        campoMessage!!.text= " $nameUser usted reporobo $subjectUser con un promedio de: $average"
                        campoMessage!!.setTextColor(Color.RED)
                    }
                }
            }

            2 ->{
                if (uNote1 > 5 || uNote1 < 1 || uNote2 > 5 || uNote2 < 1 || uNote3 > 5 || uNote3 < 1) {
                    Toast.makeText(this, "Por favor ingrese notas dentro del rango del 1 al 5", Toast.LENGTH_LONG).show()

                }
                else{
                    var average: Float = (uNote1 + uNote2 + uNote3) / 3

                    val intent = Intent(this, ActivityAverage::class.java)
                    val miBundle = Bundle()
                    miBundle.putFloat("prom", average)
                    miBundle.putString("name", nameUser)
                    miBundle.putString("subject", subjectUser)

                    intent.putExtras(miBundle)
                    startActivity(intent)
                }
            }
        }
    }
}