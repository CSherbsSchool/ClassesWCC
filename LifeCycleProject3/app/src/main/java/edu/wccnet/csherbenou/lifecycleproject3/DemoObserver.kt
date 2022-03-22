package edu.wccnet.csherbenou.lifecycleproject3

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import java.sql.Timestamp
import edu.wccnet.csherbenou.lifecycleproject3.ui.main.MainViewModel

class DemoObserver: LifecycleObserver  {

    var state = ""

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        state = "onResume"
        MainViewModel().updateCyclePrint(state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        state = "onPause"
        MainViewModel().updateCyclePrint(state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        state = "onCreate"
        MainViewModel().updateCyclePrint(state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        state = "onStart"
        MainViewModel().updateCyclePrint(state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        state = "onStop"
        MainViewModel().updateCyclePrint(state)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        state = "onDestroy"
        MainViewModel().updateCyclePrint(state)
    }

}