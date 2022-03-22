package edu.wccnet.csherbenou.lifecycleawareproject

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.MutableLiveData
import java.sql.Timestamp
import edu.wccnet.csherbenou.lifecycleawareproject.ui.main.MainViewModel

class DemoObserver: LifecycleObserver {

    var cycleLog= ""
    val tstamp = Timestamp(System.currentTimeMillis())


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        cycleLog = cycleLog + " onResume was fired at " + tstamp + "\n" + "****************\n"
        print(cycleLog)
        MainViewModel().updateCycle(cycleLog)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        cycleLog = cycleLog + " onPause was fired at " + tstamp + "\n" + "****************\n"
        print(cycleLog)
        MainViewModel().updateCycle(cycleLog)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        if (cycleLog.equals("")) {
            cycleLog = "onCreate was fired at " + tstamp + "\n" + "****************\n"
            print(cycleLog)
            MainViewModel().updateCycle(cycleLog)
        }
        else {
            cycleLog = cycleLog + " onCreate was fired at " + tstamp + "\n" + "****************\n"
            print(cycleLog)
            MainViewModel().updateCycle(cycleLog)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        cycleLog = cycleLog + " onStart was fired at " + tstamp + "\n" + "****************\n"
        print(cycleLog)
        MainViewModel().updateCycle(cycleLog)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        cycleLog = cycleLog + " onStop was fired at " + tstamp + "\n" + "****************\n"
        print(cycleLog)
        MainViewModel().updateCycle(cycleLog)

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        cycleLog = cycleLog + " onDestroy was fired at " + tstamp + "\n" + "****************\n"
        print(cycleLog)
        MainViewModel().updateCycle(cycleLog)

    }

}