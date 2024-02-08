package com.au.cities.ui.viewmodel

import com.au.cities.data.repository.TestData
import com.au.cities.domain.usecase.GetAllCitiesUseCase
import com.au.cities.domain.usecase.LoadDataUseCase
import com.au.cities.ui.UiState
import com.au.cities.ui.viewmodel.CitiesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


@ExperimentalCoroutinesApi
class CitiesViewModelTest {

    @Mock
    private lateinit var loadDataUseCase: LoadDataUseCase

    @Mock
    private lateinit var getAllCitiesUseCase: GetAllCitiesUseCase

    private lateinit var citiesViewModel: CitiesViewModel

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
        citiesViewModel = CitiesViewModel(loadDataUseCase, getAllCitiesUseCase)
    }

    @Test
    fun getAllCitiesAsc() = runTest {
        // Arrange
        val cities = TestData.mockCityList
        `when`(getAllCitiesUseCase.getItemsAsc()).thenReturn(flowOf(cities))

        // Act
        citiesViewModel.getAllCitiesAsc()

        // Assert
        assertEquals(UiState.Loading, citiesViewModel.uiState.value)

        // Advance time to allow the operation to complete
        advanceTimeBy(1000)

        assertEquals(UiState.Success(cities), citiesViewModel.uiState.first())
    }

    @Test
    fun getAllCitiesDesc() = runTest {
        // Arrange
        val cities = TestData.mockCityList
        `when`(getAllCitiesUseCase.getItemsDesc()).thenReturn(flowOf(cities))


        // Act
        citiesViewModel.getAllCitiesDesc()

        // Assert
        assertEquals(UiState.Loading, citiesViewModel.uiState.value)
        advanceTimeBy(1000)
        assertEquals(UiState.Success(cities), citiesViewModel.uiState.first())
    }

    @Test
    fun testException() = runTest {
        val exception="Test Exception"
        `when`(getAllCitiesUseCase.getItemsDesc()).thenThrow(RuntimeException(exception))
        citiesViewModel.getAllCitiesDesc()

        // Assert
        assertEquals(UiState.Loading, citiesViewModel.uiState.value)
        advanceTimeBy(1000)
        assertEquals(UiState.Error("Test Exception"), citiesViewModel.uiState.value)

        `when`(getAllCitiesUseCase.getItemsAsc()).thenThrow(RuntimeException(exception))
        citiesViewModel.getAllCitiesAsc()

        // Assert
        assertEquals(UiState.Loading, citiesViewModel.uiState.value)
        advanceTimeBy(1000)
        assertEquals(UiState.Error(exception), citiesViewModel.uiState.value)
    }
}