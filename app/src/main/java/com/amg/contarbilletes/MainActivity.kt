package com.amg.contarbilletes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit1000 = findViewById<EditText>(R.id.edit1000)
        val edit500 = findViewById<EditText>(R.id.edit500)
        val edit200 = findViewById<EditText>(R.id.edit200)
        val edit100 = findViewById<EditText>(R.id.edit100)
        val edit50 = findViewById<EditText>(R.id.edit50)
        val edit20 = findViewById<EditText>(R.id.edit20)
        val buttonCalcular = findViewById<Button>(R.id.calcular)
        val textTotal = findViewById<TextView>(R.id.textTotal)
        val buttonLimpiar = findViewById<Button>(R.id.limpiar)

        buttonCalcular.setOnClickListener(View.OnClickListener {
            var total = 0
            total+=calcularMonto(edit1000,1000)
            total+=calcularMonto(edit500,500)
            total+=calcularMonto(edit200,200)
            total+=calcularMonto(edit100,100)
            total+=calcularMonto(edit50,50)
            total+=calcularMonto(edit20,20)
            textTotal.text = "$"+total
        })

        buttonLimpiar.setOnClickListener(View.OnClickListener {
            edit1000.text.clear()
            edit500.text.clear()
            edit200.text.clear()
            edit100.text.clear()
            edit50.text.clear()
            edit20.text.clear()
            textTotal.text = "$0.00"
        })

    }

    fun calcularMonto(editText: EditText, valorBillete : Int) : Int{
        var result: Int
        var cantidad = 0
        if (editText.text.toString().isNotEmpty())
            cantidad = Integer.parseInt(editText.text.toString())
        result = cantidad * valorBillete
        return result
    }
}