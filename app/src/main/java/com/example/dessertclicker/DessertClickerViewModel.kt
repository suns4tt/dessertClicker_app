package com.example.dessertclicker

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource

class DessertClickerViewModel : ViewModel() {

    var revenue by mutableStateOf(0)
        private set

    var dessertsSold by mutableStateOf(0)
        private set

    var currentDessertIndex by mutableStateOf(0)
        private set

    // Вычисляемые свойства
    val currentDessertPrice = Datasource.dessertList[currentDessertIndex].price
    val currentDessertImageId = Datasource.dessertList[currentDessertIndex].imageId

    fun onDessertClicked() {
        revenue += currentDessertPrice
        dessertsSold++

        if (dessertsSold >= Datasource.dessertList[currentDessertIndex].startProductionAmount) {
            if (currentDessertIndex < Datasource.dessertList.size - 1) {
                currentDessertIndex++
            }
        }
    }
}