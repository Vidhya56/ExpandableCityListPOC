package com.au.cities.data.repository

import android.content.Context
import android.content.res.AssetManager
import com.au.cities.data.repository.CityRepositoryImpl
import com.au.cities.data.source.local.dao.CityDao
import com.au.cities.domain.repository.CityRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.mockito.ArgumentMatchers.anyList
import org.mockito.ArgumentMatchers.anyString

import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.io.ByteArrayInputStream
import java.io.InputStream

@ExperimentalCoroutinesApi
class CityRepositoryImplTest {

    @Mock
    private lateinit var cityDao: CityDao

    @Mock
    private lateinit var context: Context

    private lateinit var cityRepository: CityRepository

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        cityRepository = CityRepositoryImpl(cityDao, context)
    }

    @Test
    fun loadAllCitiesSuccess() = runBlocking {
        // Mock data
        val json = TestData.MOCK_CITY_JSON
        val inputStream: InputStream = ByteArrayInputStream(json.toByteArray())
        val assets: AssetManager = mock(AssetManager::class.java)

        // Mock behavior
        `when`(context.assets).thenReturn(assets)
        `when`(assets.open(anyString())).thenReturn(inputStream)

        // Call the method
        cityRepository.loadAllCities()

        // Verify the behavior
        verify(cityDao, times(1)).insertCities(anyList())
    }

    @Test
    fun getAllCitiesByAsc() = runBlocking {
        // Mock data
        val cities = TestData.mockCityList

        // Mock behavior
        `when`(cityDao.getAllCitiesAsc()).thenReturn(flowOf(cities))

        // Call the method
        val result = cityRepository.getAllCitiesByAsc()

        // Verify the result
        result.collect { emittedCities ->
            assertEquals(cities, emittedCities)
        }
    }

    @Test
    fun getAllCitiesByDesc() = runBlocking {
        // Mock data
        val cities = TestData.mockCityList

        // Mock behavior
        `when`(cityDao.getAllCitiesDesc()).thenReturn(flowOf(cities))

        // Call the method
        val result = cityRepository.getAllCitiesByDesc()

        // Verify the result
        result.collect { emittedCities ->
            assertEquals(cities, emittedCities)
        }
    }
}