package com.yyz.demo_lifecycle

import android.content.Context
import android.os.SystemClock
import android.util.AttributeSet
import android.widget.Chronometer
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author yyz (杨云召)
 * @date   2019-12-24
 * time   22:25
 * description
 */
class MyChronometer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : Chronometer(context, attrs, defStyleAttr), LifecycleObserver {

    private var elapse: Long = 0

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun pauseMeter() {
        elapse = SystemClock.elapsedRealtime() - base
        stop()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private fun resumeMeter() {
        base = SystemClock.elapsedRealtime() - elapse
        start()
    }
}