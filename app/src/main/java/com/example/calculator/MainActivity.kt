package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var textScreen = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            onClickNumberListener(but1, 1)
            onClickNumberListener(but2, 2)
            onClickNumberListener(but3, 3)
            onClickNumberListener(but4, 4)
            onClickNumberListener(but5, 5)
            onClickNumberListener(but6, 6)
            onClickNumberListener(but7, 7)
            onClickNumberListener(but8, 8)
            onClickNumberListener(but9, 9)
            onClickNumberListener(butZero, 0)
        }

    }

    private fun addNumberOnScreen(number: Int) {
        textScreen += number.toString()
    }

    private fun printUpdateScreen() {
        binding.tvScreen.text = textScreen
    }

    private fun onClickNumberListener(idNumber: Button, number: Int) {
        idNumber.setOnClickListener {
            addNumberOnScreen(number)
            printUpdateScreen()
        }
    }
}