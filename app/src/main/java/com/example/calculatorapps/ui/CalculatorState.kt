package com.example.calculatorapps.ui

data class CalculatorState(
    val number1: String ="",
    val number2: String ="",
    //data operasi bisa null krna wktu sblom mencet operatornya is Empty
    val operation: CalculatorOperation? = null
)