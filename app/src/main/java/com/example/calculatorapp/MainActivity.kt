package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var currentOperation: Char? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView2)

        val buttons = listOf<Button>(
            findViewById(R.id.button00),
            findViewById(R.id.button11),
            findViewById(R.id.button22),
            findViewById(R.id.button33),
            findViewById(R.id.button44),
            findViewById(R.id.button55),
            findViewById(R.id.button66),
            findViewById(R.id.button77),
            findViewById(R.id.button88),
            findViewById(R.id.button9),
            findViewById(R.id.buttonSum),
            findViewById(R.id.buttonSub),
            findViewById(R.id.buttonMultiply),
            findViewById(R.id.buttondiv),
            findViewById(R.id.buttonEqual),
            findViewById(R.id.buttonClear)
        )

        buttons.forEach { button ->
            button.setOnClickListener {
                onButtonClick(button.text.toString())
            }
        }
    }

    private fun onButtonClick(input: String) {
        when (input) {
            "+", "-", "X", "/" -> {
                currentOperation = input[0]
                operand1 = textView.text.toString().toDouble()
                textView.text = ""
            }
            "=" -> {
                operand2 = textView.text.toString().toDouble()
                val result = when (currentOperation) {
                    '+' -> operand1 + operand2
                    '-' -> operand1 - operand2
                    'X' -> operand1 * operand2
                    '/' -> operand1 / operand2
                    else -> 0.0
                }
                textView.text = result.toString()
                operand1 = result
                operand2 = 0.0
                currentOperation = null
            }
            "Clear" -> {
                textView.text = ""
                operand1 = 0.0
                operand2 = 0.0
                currentOperation = null
            }
            else -> {
                textView.append(input)
            }
        }
    }
}
