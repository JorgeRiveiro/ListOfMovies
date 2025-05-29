package com.jriveiro.listofmovies.data.datasources

import android.location.Geocoder
import android.location.Location
import com.jriveiro.listofmovies.ui.common.getFromLocationCompat
import javax.inject.Inject

const val DEFAULT_REGION = "ES"

interface RegionDataSource {
    suspend fun findLastRegion(): String

    suspend fun Location.toRegion(): String
}

class GeocoderRegionDataSource @Inject constructor(
    private val geocoder: Geocoder,
    private val locationDataSource: LocationDataSource
) : RegionDataSource {

    override suspend fun findLastRegion(): String =
        locationDataSource.findLastLocation()?.toRegion() ?: DEFAULT_REGION

    override suspend fun Location.toRegion(): String {
        val addresses = geocoder.getFromLocationCompat(latitude, longitude, 1)
        val region = addresses.firstOrNull()?.countryCode
        return region ?: DEFAULT_REGION
    }
}