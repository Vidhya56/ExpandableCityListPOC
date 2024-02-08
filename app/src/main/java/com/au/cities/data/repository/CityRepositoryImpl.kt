package com.au.cities.data.repository

import android.content.Context
import com.google.gson.Gson
import com.au.cities.Constants
import com.au.cities.data.source.local.dao.CityDao
import com.au.cities.data.source.local.entity.CityEntity
import com.au.cities.domain.repository.CityRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


/**
 * This class represents the implementation of the CityRepository interface.
 * It provides methods to load all cities, retrieve cities in ascending order, and retrieve cities in descending order.
 *
 * @property cityDao The data access object for city entities.
 * @property context The application context.
 */

class CityRepositoryImpl @Inject constructor(
    private val cityDao: CityDao,
    private val context: Context
) : CityRepository {

    /**
     * Loads all cities from the JSON file and inserts them into the local database.
     */
    override suspend fun loadAllCities() {
        val json = context.assets.open(Constants.CITIES_JSON).bufferedReader().use { it.readText() }
        val myData = Gson().fromJson(json, Array<CityEntity>::class.java)
        cityDao.insertCities(myData.toList())
    }

    /**
     * Retrieves all cities from the local database in ascending order.
     */
    override fun getAllCitiesByAsc(): Flow<List<CityEntity>> {
        return flow {
            cityDao.getAllCitiesAsc().collect {
                emit(it)
            }
        }
    }

    /**
     * Retrieves all cities from the local database in descending order.
     */
    override fun getAllCitiesByDesc(): Flow<List<CityEntity>> {
        return flow {
            cityDao.getAllCitiesDesc().collect {
                emit(it)
            }
        }
    }
}