package com.app.strugglepalapp

import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.app.strugglepalapp.data.Unit

class MainActivityViewModel : ViewModel() {
    private var _unitArray = getUnitArray().toMutableStateList()
    val unitArray: MutableList<Unit?>
        get() = _unitArray
}

private fun getUnitArray() = mutableListOf<Unit?>().apply {
    repeat(6) { add(null)}
}