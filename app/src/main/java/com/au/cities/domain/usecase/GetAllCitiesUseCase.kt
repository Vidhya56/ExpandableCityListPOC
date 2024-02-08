package com.au.cities.domain.usecase

import com.au.cities.domain.repository.CityRepository
import javax.inject.Inject

class GetAllCitiesUseCase  @Inject constructor(
    private val cityRepository: CityRepository
) {
    fun getItemsAsc() = cityRepository.getAllCitiesByAsc()
    fun getItemsDesc() = cityRepository.getAllCitiesByDesc()

}



