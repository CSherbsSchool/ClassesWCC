package edu.wccnet.csherbenou.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import edu.wccnet.csherbenou.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun calculateTip(view: View) {
        if (binding.billAmount.text.isNotEmpty()) {
            val dollarValue = binding.billAmount.text.toString().toFloat()
            val tip10 = dollarValue * .10f
            val tip15 = dollarValue * .15f
            val tip20 = dollarValue * .20f

            val total10 = dollarValue + tip10
            val total15 = dollarValue + tip15
            val total20 = dollarValue + tip20

            val fTip10 = "%.2f".format(tip10)
            val fTip15 = "%.2f".format(tip15)
            val fTip20 = "%.2f".format(tip20)

            val fTotal10 = "%.2f".format(total10)
            val fTotal15 = "%.2f".format(total15)
            val fTotal20 = "%.2f".format(total20)

            binding.tipsOutput.text = "10% tip: $$fTip10      Total: $$fTotal10 \n" +
                    "15% tip: $$fTip15      Total: $$fTotal15 \n" +
                    "20% tip: $$fTip20      Total: $$fTotal20"
        }
        else {
            binding.tipsOutput.text = "Please enter a bill amount."
        }
    }
}