package com.yyz.jetpacktest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var mCalculateViewModel: CalculateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.textView)

        text.text = mCalculateViewModel.number.toString()

        findViewById<Button>(R.id.button).setOnClickListener {
            mCalculateViewModel.number++
            text.text = mCalculateViewModel.number.toString()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            mCalculateViewModel.number += 2
            text.text = mCalculateViewModel.number.toString()
        }
    }
}
