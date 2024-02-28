package com.example.aplication_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getRandonNumber(view: View) {
        val textResult = findViewById<TextView>(R.id.text_result)
        val randomNumber = Random().nextInt(10)
        textResult.setText("Number: $randomNumber")
    }
}