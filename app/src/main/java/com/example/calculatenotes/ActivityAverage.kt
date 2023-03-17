package com.example.calculatenotes

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityAverage : AppCompatActivity() {

    var average: Float? = null
    var name: String? = null
    var subject: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_average)

        val campoMessage=findViewById<TextView>(R.id.txtMensaje)

        var miBundle: Bundle? = this.intent.extras


        if (miBundle != null){
            name=miBundle.getString("name")
            average = miBundle.getFloat("prom")
            subject = miBundle.getString("subject")
        }

        if (average!! >= 3.5){
            campoMessage!!.text= "Felicidades $name usted aprobo $subject con un promedio de: $average"
            campoMessage!!.setTextColor(Color.GREEN)

        }
        else{
            campoMessage!!.text= " $name usted reporobo $subject con un promedio de: $average"
            campoMessage!!.setTextColor(Color.RED)
        }


        val btnSalir:Button = findViewById(R.id.btnSalir)
        btnSalir.setOnClickListener { onClick() }


    }


        private fun onClick(){
            finish()
        }

    }
