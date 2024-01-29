package ui

import androidx.compose.runtime.mutableStateOf
import kotlin.math.pow

class ViewModel() {

    var formulaText = mutableStateOf("")
    var resultText = mutableStateOf("")

    fun click(char: Char){
        when(char){
            'C' -> {
                formulaText.value = ""
                resultText.value = ""
            }
            '⌫' -> formulaText.value = formulaText.value.dropLast(1)
            '=' -> {
                val result = calculate()
                formulaText.value = ""
                resultText.value = if (result % 1 == 0.0) {
                    result.toInt().toString()
                } else {
                    result.toString()
                }
            }
            else -> {
                formulaText.value += char
                resultText.value = formulaText.value.split(Regex("[\\+\\-\\*/^%]")).last()
            }
        }
    }

    private fun calculate(): Double {
        // Split the expression into operands and operator
        val expression = formulaText.value
        val parts = expression.split(Regex("[\\+\\-\\*/^%]"))
        if (
            parts.size == 1
        ) {
            return parts[0].toDoubleOrNull() ?: return Double.NaN
        }
        val operand1 = parts[0].toDoubleOrNull() ?: return Double.NaN
        val operand2 = parts[1].toDoubleOrNull() ?: return Double.NaN

        // Extract the operator
        val operator = expression.find { it.isDigit().not() } ?: return Double.NaN

        // Perform the calculation based on the operator
        return when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> operand1 / operand2
            '^' -> operand1.pow(operand2)
            '%' -> operand1 % operand2
            else -> Double.NaN
        }
    }
}