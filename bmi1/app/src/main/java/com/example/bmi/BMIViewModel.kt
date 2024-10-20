package com.example.bmi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

class BMIViewModel : ViewModel() {

    private val height_ = mutableStateOf("")
    val height: State<String> = height_

    private val weight_ = mutableStateOf("")
    val weight: State<String> = weight_

    private val bmi_ = mutableStateOf("")
    val bmi: State<String> = bmi_

    fun setHeight(newHeight: String) {
        height_.value = newHeight
        calculateBMI()
    }

    fun setWeight(newWeight: String) {
        weight_.value = newWeight
        calculateBMI()
    }

    private fun calculateBMI() {
        val heightValue = height_.value.toFloatOrNull()
        val weightValue = weight_.value.toFloatOrNull()

        if (heightValue != null && weightValue != null && heightValue > 0) {
            val bmiValue = weightValue/ (heightValue * heightValue)
            bmi_.value = String.format("%.2f", bmiValue)
        } else {
            bmi_.value = ""
        }
    }
}