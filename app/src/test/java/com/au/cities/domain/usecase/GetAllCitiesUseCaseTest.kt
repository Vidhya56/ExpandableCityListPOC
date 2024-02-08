package com.au.cities.domain.usecase

import com.au.cities.domain.usecase.GetAllCitiesUseCase
import org.mockito.Mockito.*
import com.au.cities.domain.repository.CityRepository
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetAllCitiesUseCaseTest {

    @Mock
    private lateinit var cityRepository: CityRepository

    private lateinit var getAllCitiesUseCase: GetAllCitiesUseCase


    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        getAllCitiesUseCase = GetAllCitiesUseCase(cityRepository)
    }

    @Test
    fun getItemsAsc() {
        getAllCitiesUseCase.getItemsAsc()
        verify(cityRepository).getAllCitiesByAsc()
    }

    @Test
    fun getItemsDesc() {
        getAllCitiesUseCase.getItemsDesc()
        verify(cityRepository).getAllCitiesByDesc()
    }
}