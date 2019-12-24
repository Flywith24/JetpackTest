package com.yyz.jetpacktest

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProviders
import com.yyz.jetpacktest.viewModel.SavedStateViewModel

class MainActivity : AppCompatActivity() {
    //    private lateinit var mCalculateViewModel: CalculateViewModel
    private lateinit var mSavedStateViewModel: SavedStateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mCalculateViewModel = ViewModelProviders.of(this).get(CalculateViewModel::class.java)
        mSavedStateViewModel =
            ViewModelProviders.of(this, SavedStateViewModelFactory(application, this))
                .get(SavedStateViewModel::class.java)

        val text = findViewById<TextView>(R.id.textView)

        text.text = mSavedStateViewModel.number.toString()

        findViewById<Button>(R.id.button).setOnClickListener {
            mSavedStateViewModel.number++
            text.text = mSavedStateViewModel.number.toString()
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            mSavedStateViewModel.number += 2
            text.text = mSavedStateViewModel.number.toString()
        }
    }
}
