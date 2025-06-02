package com.jriveiro.region

import android.location.Geocoder
import com.jriveiro.region.data.DEFAULT_REGION
import com.jriveiro.data.datasource.LocationDataSource
import com.jriveiro.data.datasource.RegionDataSource
import com.jriveiro.domain.Location
import com.jriveiro.region.getFromLocationCompat
import javax.inject.Inject

class GeocoderRegionDataSource @Inject constructor(
    private val geocoder: Geocoder,
    private val locationDataSource: LocationDataSource
) : RegionDataSource {

    override suspend fun findLastRegion(): String =
        locationDataSource.findLastLocation()?.toRegion() ?: com.jriveiro.region.data.DEFAULT_REGION

    suspend fun Location.toRegion(): String {
        val addresses = geocoder.getFromLocationCompat(latitude, longitude, 1)
        val region = addresses.firstOrNull()?.countryCode
        return region ?: DEFAULT_REGION
    }
}