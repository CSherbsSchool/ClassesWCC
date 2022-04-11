package edu.wccnet.csherbenou.intentsproject.ui.main

import androidx.lifecycle.ViewModel
import edu.wccnet.csherbenou.intentsproject.Data

class MainViewModel : ViewModel() {

    companion object {
        var ranImages: MutableList<Int> = Data().getImage()

        var ranTitles: MutableList<String> = Data().getTitle()

        var ranDetails: MutableList<String> = Data().getDetail()

    }


}