package com.example.lab_3

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var randomNumber = (1..10).random()

    private lateinit var editTextNumber: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextText)
        resultTextView = findViewById(R.id.textView2)
        val compareButton: Button = findViewById(R.id.button)

        compareButton.setOnClickListener {
            compareNumbers()
        }

        editTextNumber.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                editTextNumber.text.clear()
            }
        }
    }

    private fun compareNumbers() {
        val userNumberText = editTextNumber.text.toString()

        if (userNumberText.isNotEmpty()) {
            val userNumber = userNumberText.toInt()

            if (userNumber == randomNumber) {
                resultTextView.text = getString(R.string.guessed)
            } else {
                resultTextView.text = getString(R.string.not_guessed)
            }

            randomNumber = (1..10).random()
        } else {
            resultTextView.text = getString(R.string.enter_number)
        }
    }
}
