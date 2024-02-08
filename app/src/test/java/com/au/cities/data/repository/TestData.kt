package com.au.cities.data.repository

import com.au.cities.data.source.local.entity.CityEntity

object TestData {

    val mockCityList = listOf(
        CityEntity( city = "city1", admin_name = "state1", country = "country1", population = "population1", capital = "capital1", lat = "lat1", lng = "lng1", iso2 = "iso21",  population_proper = "populationProper1", isExpanded = false),
        CityEntity( city = "city2", admin_name = "state2", country = "country2", population = "population2", capital = "capital2", lat = "lat2", lng = "lng2", iso2 = "iso22",  population_proper = "populationProper2", isExpanded = false),
        CityEntity( city = "city3", admin_name = "state3", country = "country3", population = "population3", capital = "capital3", lat = "lat3", lng = "lng3", iso2 = "iso23",  population_proper = "populationProper3", isExpanded = false)
    )
    const val MOCK_CITY_JSON = "[\n" +
            "  {\n" +
            "    \"city\": \"Sydney\", \n" +
            "    \"lat\": \"-33.8678\", \n" +
            "    \"lng\": \"151.2100\", \n" +
            "    \"country\": \"Australia\", \n" +
            "    \"iso2\": \"AU\", \n" +
            "    \"admin_name\": \"New South Wales\", \n" +
            "    \"capital\": \"admin\", \n" +
            "    \"population\": \"4840600\", \n" +
            "    \"population_proper\": \"4840600\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"city\": \"Melbourne\", \n" +
            "    \"lat\": \"-37.8142\", \n" +
            "    \"lng\": \"144.9631\", \n" +
            "    \"country\": \"Australia\", \n" +
            "    \"iso2\": \"AU\", \n" +
            "    \"admin_name\": \"Victoria\", \n" +
            "    \"capital\": \"admin\", \n" +
            "    \"population\": \"4529500\", \n" +
            "    \"population_proper\": \"4529500\"\n" +
            "  }, \n" +
            "  {\n" +
            "    \"city\": \"Brisbane\", \n" +
            "    \"lat\": \"-27.4678\", \n" +
            "    \"lng\": \"153.0281\", \n" +
            "    \"country\": \"Australia\", \n" +
            "    \"iso2\": \"AU\", \n" +
            "    \"admin_name\": \"Queensland\", \n" +
            "    \"capital\": \"admin\", \n" +
            "    \"population\": \"2360241\", \n" +
            "    \"population_proper\": \"2360241\"\n" +
            "  }]"

    // Add more mock data as needed
}