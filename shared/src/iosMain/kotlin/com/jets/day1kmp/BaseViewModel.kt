package com.jets.day1kmp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

actual open class BaseViewModel {
    actual val scope = CoroutineScope(Dispatchers.Main)
}