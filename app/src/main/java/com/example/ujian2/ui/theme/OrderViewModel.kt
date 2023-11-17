package com.example.ujian2.ui.theme

import androidx.lifecycle.ViewModel
import com.example.ujian2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setDosen(dosenPilihan: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dosen = dosenPilihan)
        }
    }
}