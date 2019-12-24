package com.yyz.demo_lifecycle

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {

    private var elapse: Long = 0
    private lateinit var mChronometer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        mChronometer = findViewById(R.id.meter)
        mChronometer.base = SystemClock.elapsedRealtime()
    }

    override fun onPause() {
        super.onPause()
        elapse = SystemClock.elapsedRealtime() - mChronometer.base
        mChronometer.stop()
    }

    override fun onResume() {
        super.onResume()
        mChronometer.base = SystemClock.elapsedRealtime() - elapse
        mChronometer.start()
    }
}