package com.example.temperatura

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

// Activity principal da aplicação
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referências dos componentes da interface
        val layoutPrincipal = findViewById<ConstraintLayout>(R.id.main)
        val editTextTemperatura = findViewById<EditText>(R.id.editTextTemperatura)
        val buttonCtoF = findViewById<Button>(R.id.buttonCtoF)
        val buttonFtoC = findViewById<Button>(R.id.buttonFtoC)
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)
        val buttonMudarCor = findViewById<Button>(R.id.buttonMudarCor)

        // Estado atual da cor de fundo
        var fundoAzul = true

        // Converte de Celsius para Fahrenheit
        buttonCtoF.setOnClickListener {
            val input = editTextTemperatura.text.toString().toDoubleOrNull()

            if (input != null) {
                val resultado = (input * 9 / 5.0) + 32
                val resultadoFormatado = String.format("%.2f", resultado)
                textViewResultado.text = "Resultado: $resultadoFormatado °F"
            } else {
                textViewResultado.text = "Digite um valor válido"
            }
        }

        // Converte de Fahrenheit para Celsius
        buttonFtoC.setOnClickListener {
            val input = editTextTemperatura.text.toString().toDoubleOrNull()

            if (input != null) {
                val resultado = (input - 32) * 5 / 9.0
                val resultadoFormatado = String.format("%.2f", resultado)
                textViewResultado.text = "Resultado: $resultadoFormatado °C"
            } else {
                textViewResultado.text = "Digite um valor válido"
            }
        }

        // Alterna a cor de fundo entre azul e vermelho
        buttonMudarCor.setOnClickListener {
            if (fundoAzul) {
                layoutPrincipal.setBackgroundColor(Color.GRAY)
            } else {
                layoutPrincipal.setBackgroundColor(Color.LTGRAY)
            }
            fundoAzul = !fundoAzul
        }
    }
}
