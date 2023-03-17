package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var textScreen = ""
    private var num1 = ""
    private var num2 = ""
    private var charOfOperation = ""
    private var result = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            onClickNumberListener(but1, "1")
            onClickNumberListener(but2, "2")
            onClickNumberListener(but3, "3")
            onClickNumberListener(but4, "4")
            onClickNumberListener(but5, "5")
            onClickNumberListener(but6, "6")
            onClickNumberListener(but7, "7")
            onClickNumberListener(but8, "8")
            onClickNumberListener(but9, "9")
            onClickNumberListener(butZero, "0")
            onClickNumberListener(butDot, ".")
            onClickOperationsListener(butAdd, "+")
            onClickOperationsListener(butDifferent, "-")
            onClickOperationsListener(butMultiply, "*")
            onClickOperationsListener(butDivide, "/")
//            onClickResult(butEqually, "=")
        }
    }

    private fun onClickNumberListener(idNumber: Button, number: String) {
        idNumber.setOnClickListener {
            when(charOfOperation) {
                "" -> {
                    num1 += number
                    binding.tvScreenNum1.text = num1
                }

                "+" -> {
                    num2 += number
                    binding.tvScreenNum1.text = "$num1 $charOfOperation $num2 = ${sumNumbers(num1, num2)}"
                }
                "-" -> {
                    num2 += number
                    binding.tvScreenNum1.text = "$num1 $charOfOperation $num2 = ${difNumbers(num1, num2)}"
                }
                "*" -> {
                    num2 += number
                    binding.tvScreenNum1.text = "$num1 $charOfOperation $num2 = ${multyNumbers(num1, num2)}"
                }
                "/" -> {
                    num2 += number
                    binding.tvScreenNum1.text = "$num1 $charOfOperation $num2 = ${divideNumbers(num1, num2)}"
                }
            }
        }
    }

    private fun onClickOperationsListener(idNumber: Button, char: String) {
        idNumber.setOnClickListener {
            charOfOperation = char
            binding.tvScreenNum1.text = "$num1 $charOfOperation"
        }
    }

    private fun sumNumbers(num1: String, num2: String): Any {
        return if (num1.isDigitsOnly() && num2.isDigitsOnly())
            num1.toInt() + num2.toInt()
        else
            num1.toDouble() + num2.toDouble()
    }

    private fun difNumbers(num1: String, num2: String): Any {
        return if (num1.isDigitsOnly() && num2.isDigitsOnly())
            num1.toInt() - num2.toInt()
        else
            num1.toDouble() - num2.toDouble()
    }

    private fun multyNumbers(num1: String, num2: String): Any {
        return if (num1.isDigitsOnly() && num2.isDigitsOnly())
            num1.toInt() * num2.toInt()
        else
            num1.toDouble() * num2.toDouble()
    }

    private fun divideNumbers(num1: String, num2: String): Double {
        return num1.toDouble() / num2.toDouble()
    }



//
//
//    private fun printTextScreen(num1: Int, num2: Int, charOfOperation: String, result: Int) {
//        textScreen = "$num1$charOfOperation$num2=$result"
//    }
//
//
//

//
//    private fun onClickResult(idNumber: Button, char: String) {
//        if (textScreen != "") num2 = textScreen.toInt()
//        result = equally(num1, num2, char)
//        binding.tvScreenNum1.text = result.toString()
//    }
//

//
//    fun equally(num1: Int, num2: Int, char: String): Int {
//        val result: Int
//        when (char) {
//            "+" -> result = sumNumbers(num1, num2)
//            else -> result = 0
//        }
//        return result
//    }

}