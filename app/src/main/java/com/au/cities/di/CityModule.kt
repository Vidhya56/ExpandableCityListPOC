package com.au.cities.di

import android.content.Context
import com.au.cities.data.repository.CityRepositoryImpl
import com.au.cities.data.source.local.dao.CityDao
import com.au.cities.domain.repository.CityRepository
import com.au.cities.domain.usecase.GetAllCitiesUseCase
import com.au.cities.domain.usecase.LoadDataUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object CityModule {

    @Provides
    fun provideCityRepository(cityDao: CityDao, @ApplicationContext context: Context): CityRepository =
        CityRepositoryImpl(cityDao,context)

    @Provides
    fun provideGetAllStatesUseCase(cityRepository: CityRepository): GetAllCitiesUseCase =
        GetAllCitiesUseCase(cityRepository)

    @Provides
    fun provideLoadCitiesUseCase(cityRepository: CityRepository): LoadDataUseCase =
        LoadDataUseCase(cityRepository)

}