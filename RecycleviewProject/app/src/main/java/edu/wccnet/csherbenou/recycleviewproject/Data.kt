package edu.wccnet.csherbenou.recycleviewproject

class Data {

    companion object {
        val titles = arrayOf(
            "Chapter One",
            "Chapter Two", "Chapter Three", "Chapter Four",
            "Chapter Five", "Chapter Six", "Chapter Seven",
            "Chapter Eight"
        )

        val details = arrayOf(
            "Item one details", "Item two details",
            "Item three details", "Item four details",
            "Item five details", "Item six details",
            "Item seven details", "Item eight details"
        )

        val images = intArrayOf(
            R.drawable.android_image_1,
            R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5,
            R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8
        )
        var newImages: MutableList<Int> = mutableListOf()

        var newTitles: MutableList<String> = mutableListOf()

        var newDetails: MutableList<String> = mutableListOf()

    }

    fun getImage() : MutableList<Int> {
        newImages = Data.images.toMutableList()
        newImages.shuffle()
        return newImages
    }


    fun getTitle() : MutableList<String> {
        newTitles = Data.titles.toMutableList()
        newTitles.shuffle()
        return newTitles
    }

    fun getDetail() : MutableList<String> {
        newDetails = Data.details.toMutableList()
        newDetails.shuffle()
        return newDetails
    }
}