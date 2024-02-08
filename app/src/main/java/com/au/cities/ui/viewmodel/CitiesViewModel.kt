package com.au.cities.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.au.cities.data.source.local.entity.CityEntity
import com.au.cities.domain.usecase.GetAllCitiesUseCase
import com.au.cities.domain.usecase.LoadDataUseCase
import com.au.cities.ui.OrderType
import com.au.cities.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A ViewModel that manages the data for the Cities screen.
 *
 * @param loadDataUseCase The use case for loading data.
 * @param getAllCitiesUseCase The use case for getting all cities.
 */
@HiltViewModel
open class CitiesViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val getAllCitiesUseCase: GetAllCitiesUseCase
) : ViewModel() {

    /**
     * The UI state of the screen.
     */
    private val _uiState = MutableStateFlow<UiState<List<CityEntity>?>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    /**
     * The sort order of the cities.
     */
    var sortOrder: OrderType = OrderType.ASCENDING

    init {
        viewModelScope.launch(Dispatchers.IO) {
            loadInitialData()
        }
    }

    /**
     * Loads the initial data for the screen.
     */
    private suspend fun loadInitialData() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.value = UiState.Loading
            loadDataUseCase.addAllCities()
            _uiState.value = try {
                UiState.Success(getAllCitiesUseCase.getItemsAsc().first())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "An unexpected error occurred")
            }
        }
    }

    /**
     * Gets all cities by Ascending order.
     */
    fun getAllCitiesAsc() {
        _uiState.value = UiState.Loading
        sortOrder =
            if (sortOrder == OrderType.ASCENDING) OrderType.DESCENDING else OrderType.ASCENDING
        viewModelScope.launch {
            delay(500)
            _uiState.value = try {
                UiState.Success(getAllCitiesUseCase.getItemsAsc().first())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "An unexpected error occurred")
            }
        }
    }

    /**
     * Gets all cities by Descending order.
     */
    fun getAllCitiesDesc() {
        _uiState.value = UiState.Loading
        sortOrder =
            if (sortOrder == OrderType.ASCENDING) OrderType.DESCENDING else OrderType.ASCENDING
        viewModelScope.launch {
            delay(500)
            _uiState.value = try {
                UiState.Success(getAllCitiesUseCase.getItemsDesc().first())
            } catch (e: Exception) {
                UiState.Error(e.message ?: "An unexpected error occurred")
            }
        }
    }
}
