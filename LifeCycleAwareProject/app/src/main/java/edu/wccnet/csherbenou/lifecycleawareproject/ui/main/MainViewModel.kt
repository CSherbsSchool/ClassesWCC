package edu.wccnet.csherbenou.lifecycleawareproject.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.wccnet.csherbenou.lifecycleawareproject.DemoObserver

class MainViewModel : ViewModel() {

    var cycleOutput = ""

    fun updateCycle(update: String) {
        cycleOutput = cycleOutput + update + "\n"
    }

}