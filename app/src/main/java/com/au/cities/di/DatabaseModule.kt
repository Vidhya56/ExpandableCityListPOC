package com.au.cities.di

import android.content.Context
import androidx.room.Room
import com.au.cities.Constants.Companion.DATABASE_NAME
import com.au.cities.data.source.local.dao.CityDao
import com.au.cities.data.source.local.CityDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCityDatabase(@ApplicationContext appContext: Context): CityDatabase {
        return Room.databaseBuilder(
            appContext,
            CityDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideCityDao(cityDatabase: CityDatabase): CityDao {
        return cityDatabase.cityDao()
    }
}