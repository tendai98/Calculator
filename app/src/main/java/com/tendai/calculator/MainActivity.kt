package com.tendai.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private var inputTextView: TextView? = null
    var lastNumeric : Boolean = false
    private var lastDot : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputTextView = findViewById(R.id.text_view_input)
    }

    fun onOperator(view: View){
        inputTextView?.text?.let{
            if(lastNumeric && !isOperatorAdded(it.toString())){
                inputTextView?.append((view as Button).text)
                lastNumeric = false
                lastDot = false
            }
        }
    }

    private fun isOperatorAdded(value: String) : Boolean{
        return if(value.startsWith("-")){
            false
        }else{
            value.contains("/")
            || value.contains("*")
            || value.contains("+")
            || value.contains("-")
        }
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

    fun onOperation(view: View){
        if(lastNumeric){
            var operation = inputTextView?.text.toString()


            try{
                var operands = operation.split("-")

                var operand1 = operands[0]
                var operand2 = operands[1]

                var result = (operand1.toDouble() - operand2.toDouble())

                inputTextView?.text =  result.toString()

            }catch(e: ArithmeticException){
                e.printStackTrace()
            }
        }
    }
}