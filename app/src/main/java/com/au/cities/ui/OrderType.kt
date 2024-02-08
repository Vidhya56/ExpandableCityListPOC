package com.au.cities.ui

sealed class OrderType {
    data object ASCENDING : OrderType()
    data object DESCENDING : OrderType()
}
