package com.au.cities.domain.usecase

import com.au.cities.domain.repository.CityRepository
import javax.inject.Inject

/**
 * Use case for loading all cities from the repository.
 *
 * @param cityRepository The city repository.
 */
class LoadDataUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {

    /**
     * Adds all cities from the repository to the database.
     */
    suspend fun addAllCities() = cityRepository.loadAllCities()
}