package edu.wccnet.csherbenou.lifecycleproject3.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Timestamp

class MainViewModel : ViewModel() {

    var cycleLog = ""
    val tstamp = Timestamp(System.currentTimeMillis())

    fun updateCyclePrint(state: String){
        if (cycleLog.equals(null)) {
            cycleLog = state + " was fired at " + tstamp + "\n" + "****************\n"
            print(cycleLog)
        }
        else {
            cycleLog = cycleLog + state + " was fired at " + tstamp + "\n" + "****************\n"
            print(cycleLog)
        }
    }

    fun getCycle() : String {
        return cycleLog
    }

}