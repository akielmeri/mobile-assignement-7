package com.example.bmi

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class BmiViewModel : ViewModel() {
    var heightInput: String by mutableStateOf("")
    var weightInput: String by mutableStateOf("")

    var bmi: Double by mutableStateOf(0.0)
        private set

    fun updateHeightInput(newHeight: String) {
        heightInput = newHeight
        calculateBmi()
    }

    fun updateWeightInput(newWeight: String) {
        weightInput = newWeight
        calculateBmi()
    }

    private fun calculateBmi() {
        val height = heightInput.toFloatOrNull() ?: 0.0f
        val weight = weightInput.toIntOrNull() ?: 0

        bmi = if (weight > 0 && height > 0) (weight / (height * height)).toDouble() else 0.0
    }

}
