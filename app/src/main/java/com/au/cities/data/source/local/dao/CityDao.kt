package com.au.cities.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.au.cities.Constants
import com.au.cities.data.source.local.entity.CityEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface CityDao {

    /*
    * Inserts a list of cities into the database.
    * If a city with the same primary key already exists in the database, it will be replaced.
    */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCities(cities: List<CityEntity>)

    //Retrieves all cities by state ordered in Ascending order from the database.
    @Query("SELECT * from ${Constants.CITY_TABLE_NAME}  ORDER BY admin_name ASC, city ASC")
    fun getAllCitiesAsc(): Flow<List<CityEntity>>


    //Retrieves all cities by state ordered in Descending order from the database.
    @Query("SELECT * from ${Constants.CITY_TABLE_NAME} ORDER BY admin_name DESC, city DESC")
    fun getAllCitiesDesc(): Flow<List<CityEntity>>

}