package com.tendai.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var inputTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputTextView = findViewById(R.id.text_view_input)

    }

    fun onDigit(view: View){
        inputTextView?.append("1")
    }

    fun onClear(view: View){

    }
}