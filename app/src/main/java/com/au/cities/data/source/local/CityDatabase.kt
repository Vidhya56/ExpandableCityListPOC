package com.au.cities.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.au.cities.data.source.local.dao.CityDao
import com.au.cities.data.source.local.entity.CityEntity

/**
 * A Room database for storing city data.
*/
@Database(entities = [CityEntity::class], version = 1, exportSchema = false)
abstract class CityDatabase : RoomDatabase() {
    /**
     * Gets the city DAO.
     */
    abstract fun cityDao(): CityDao
}