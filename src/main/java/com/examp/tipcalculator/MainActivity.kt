package com.examp.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.examp.tipcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener {
            val billTotal = binding.billTotalEditText.text.toString()

            if (billTotal.isEmpty()) {
                binding.tipResultTextView.text = "YOU MUST ENTER A BILL AMOUNT"
            } else {
                val totalAmount = billTotal.toDouble()
                val tip10 = calculateTip(totalAmount, 0.10)
                val tip15 = calculateTip(totalAmount, 0.15)
                val tip20 = calculateTip(totalAmount, 0.20)

                binding.tipResultTextView.text =
                    "The tips are as follows:\n\n" +
                            "10% = $tip10\n" +
                            "15% = $tip15\n" +
                            "20% = $tip20"
            }
        }
    }

    private fun calculateTip(amount: Double, percentage: Double): String {
        return String.format("%.2f", amount * percentage)
    }
}
