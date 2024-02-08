package com.au.cities.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.au.cities.Constants.Companion.CITY_TABLE_NAME

@Entity(tableName = CITY_TABLE_NAME)
data class CityEntity(
    @PrimaryKey
    val city: String,
    val lat: String?,
    val lng: String?,
    val country: String?,
    val iso2: String?,
    val admin_name: String?,
    val capital: String?,
    val population: String?,
    val population_proper: String?,
    val isExpanded:Boolean)
