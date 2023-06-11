package com.example.flowdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ShareFlowViewModel  : ViewModel() {

    private val _sharedFlow = MutableSharedFlow<Int>(
        replay = 10,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )

    fun startSharedFlow() {

        viewModelScope.launch {
            for (i in 1..5) {
                _sharedFlow.emit(i)
                delay(2000)
            }
        }
    }

    val sharedFlow = _sharedFlow.asSharedFlow()
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()

    fun increaseValue() {
        _stateFlow.value += 1
    }

    val myFlow: Flow<Int> = flow {
        for (i in 1..5) {
            delay(1000)
            emit(i)
        }
    }

    fun doubleIt(value: Int) = flow {
        emit(value)
        delay(1000)
        emit(value + value)
    }

/*
    val myFlow: Flow<Int> = flow {
        for (i in 0..9) {
            emit(i)
            delay(2000)
        }
    }

    val newFlow = myFlow.map {
        "Current value = $it"
    }
*/
/*
    val newFlow = myFlow
        .transform {
            emit("Value = $it")
            delay(1000)
            val doubled = it * 2
            emit("Value doubled = $doubled")
        }
 */
}