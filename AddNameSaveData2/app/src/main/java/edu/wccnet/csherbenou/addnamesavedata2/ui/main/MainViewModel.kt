package edu.wccnet.csherbenou.addnamesavedata2.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {

    var editTextEnterName: MutableLiveData<String> = MutableLiveData()
    var namesList: MutableLiveData<String> = MutableLiveData()

    fun addNames() {
        if (namesList.value.equals(null)) {
                namesList.value = editTextEnterName.value + "\n"
        }
        else {
                namesList.value = namesList.value + editTextEnterName.value + "\n"
        }
    }


}