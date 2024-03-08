package com.example.calculatorapps.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    //Private set = dapat mengubah state dari luar tapi masih bisa diakses dn dibaca
    //Menghindari mengubah state dari UI (Make Background Thread)
    var state by mutableStateOf(CalculatorState())
        private set
//    private var operation

    fun onAction(actions: CalculatorActions) {
        when (actions) {
            is CalculatorActions.Number -> enterNumber(actions.number)
            is CalculatorActions.Decimal -> enterDecimal()
            //Inisialisasi state lagi
            is CalculatorActions.Clear -> state = CalculatorState()
            is CalculatorActions.Operation -> enterOperation(actions.operation)
            is CalculatorActions.Delete -> performDelete()
            is CalculatorActions.Calculate -> performCalculate()
        }
        Log.e("Action", actions.toString())
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {
            if (state.number1.length >= MAX_NUM_LENGTH) {
                return
            }
            state = state.copy(
                number1 = state.number1 + number
            )
            return
        }
        if (state.number2.length >= MAX_NUM_LENGTH) {
            return
        }
        state = state.copy(
            number2 = state.number2 + number
        )
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.number1.contains(".")
            && state.number1.isNotBlank()
        ) {
            state = state.copy(
                number1 = state.number1 + "."
            )
            return
        }
        if (!state.number2.contains(".") && state.number2.isNotBlank()
        ) {
            state = state.copy(number1 = state.number2 + ".")
        }
    }

    //Kita tidak ingin mengklik tanda operasi di awal, karena initial state awalnya masih empty
    // dn ketika ada perubahan hrus menyimpan nilai
    private fun enterOperation(operation: CalculatorOperation) {
        if (state.number1.isNotBlank()) {
            //Make new State
            //Mengcopy dri state yg ada
            state = state.copy(operation = operation)
            //Jika benar, state bernilai sesuai input parameter operasi
            //Tanpa membutuhkan single fields dari mutable state sehingga mentrigger/membuat
            //rekomposisi disini
        }
    }

    private fun performDelete() {
        when {
            //number 2 tidak ksong maka, dapat mendelete karakter akhir
            //state = state.copy
            //state bernilai baru dari sesuai parameter karakter nomer 2 yg dihapus 1 angka(n)
            // dari belakang (dropLast)
            // n = 1 (kuantitas)
            state.number2.isNotBlank() -> state = state.copy(number2 = state.number2.dropLast(1))
            //Operation diset kan null krna operasi itu tunggal. G mungkin bisa +-
            state.operation != null -> state = state.copy(operation = null)
            state.number1.isNotBlank() -> state = state.copy(number1 = state.number1.dropLast(1))
        }
    }

    //Saat sudah muncul
    private fun performCalculate() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()
        if (number1 != null && number2 != null) {
            val result = when (state.operation) {
                is CalculatorOperation.Add -> number1 + number2
                is CalculatorOperation.Subtract -> number1 - number2
                is CalculatorOperation.Divide -> number1 / number2
                is CalculatorOperation.Multiple -> number1 * number2
                null -> return
            }
            state = state.copy(
                //hasil hanya sejumlah maksimal 15 karakter
                number1 = result.toString().take(15),
                number2 = "",
                operation = null
            )
        }
    }
}