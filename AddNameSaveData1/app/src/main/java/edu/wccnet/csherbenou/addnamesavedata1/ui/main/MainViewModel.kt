package edu.wccnet.csherbenou.addnamesavedata1.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var editTextEnterName = ""
    private var namesList = ""

    fun addNames(name: String) {
        this.editTextEnterName = name
        namesList = "$namesList $name\n"
    }

    fun getNames() : String {
        return namesList
    }

}