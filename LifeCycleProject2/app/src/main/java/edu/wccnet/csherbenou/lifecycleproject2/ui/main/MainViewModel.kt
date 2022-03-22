package edu.wccnet.csherbenou.lifecycleproject2.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Timestamp

class MainViewModel : ViewModel() {

    var cycleLog: MutableLiveData<String> = MutableLiveData()
    val tstamp = Timestamp(System.currentTimeMillis())

    fun updateCyclePrint(state: String){
        if (cycleLog.value.equals(null)) {
            cycleLog.value = state + " was fired at " + tstamp + "\n" + "****************\n"
            print(cycleLog.value)
        }
        else {
            cycleLog.value = cycleLog.value + state + " was fired at " + tstamp + "\n" + "****************\n"
            print(cycleLog.value)
        }

    }

}