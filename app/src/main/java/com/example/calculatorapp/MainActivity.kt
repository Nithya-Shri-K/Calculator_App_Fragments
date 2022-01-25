package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val IS_RESULT_PAGE = "Is_Result_Page"
const val RESULT = "result"
const val REQUEST_KEY = "requestKey"
const val OPERAND1 = "operand1"
const val OPERAND2 = "operand2"
const val OPERATION = "operation"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}