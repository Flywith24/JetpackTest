package com.yyz.demo_lifecycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mChronometer: MyChronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mChronometer = findViewById(R.id.meter)
        lifecycle.addObserver(mChronometer)
    }
}