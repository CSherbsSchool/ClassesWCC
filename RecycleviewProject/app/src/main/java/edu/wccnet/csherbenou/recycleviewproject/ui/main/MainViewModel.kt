package edu.wccnet.csherbenou.recycleviewproject.ui.main

import androidx.lifecycle.ViewModel
import kotlin.collections.shuffle
import edu.wccnet.csherbenou.recycleviewproject.Data
import edu.wccnet.csherbenou.recycleviewproject.R
import java.util.Collections.shuffle

class MainViewModel : ViewModel() {

        companion object {
                var ranImages: MutableList<Int> = Data().getImage()

                var ranTitles: MutableList<String> = Data().getTitle()

                var ranDetails: MutableList<String> = Data().getDetail()
        }


}