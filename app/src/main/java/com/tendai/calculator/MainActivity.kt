package com.tendai.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var inputTextView: TextView? = null
    var lastNumeric : Boolean = false
    var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.text_view_input)

    }
    
    fun onOperator(view: View){

    }

    fun onDigit(view: View){
        val btn = (view as Button)
        inputTextView?.append(btn.text)
        lastNumeric = true
        lastDot = false
    }

    fun onClear(view: View){
        inputTextView?.text = ""
    }

    fun onDecimalPoint(view: View){
        if(lastNumeric && !lastDot){
            inputTextView?.append(".")
            lastNumeric = false
            lastDot = true
        }
    }
}