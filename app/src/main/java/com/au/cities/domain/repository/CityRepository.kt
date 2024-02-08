package com.au.cities.domain.repository

import com.au.cities.data.source.local.entity.CityEntity
import kotlinx.coroutines.flow.Flow

interface CityRepository {
    suspend fun loadAllCities()
     fun getAllCitiesByAsc(): Flow<List<CityEntity>>
     fun getAllCitiesByDesc(): Flow<List<CityEntity>>
}