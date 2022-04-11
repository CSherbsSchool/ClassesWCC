package edu.wccnet.csherbenou.intentsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wccnet.csherbenou.intentsproject.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras ?: return

        val getTitle = extras.getString("title")

        val getDetail = extras.getString("detail")

        val getImage = extras.getInt("image")

        binding.textTitle.text = getTitle

        binding.textDetail.text = getDetail

        binding.imageView.setImageResource(getImage)
    }

}