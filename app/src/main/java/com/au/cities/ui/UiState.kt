package com.au.cities.ui


/**
 * Represents the state of the UI.
 *
 * @param T The type of data that the UI is displaying.
 */

sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val error: String) : UiState<Nothing>()
    data object Loading : UiState<Nothing>()
}


