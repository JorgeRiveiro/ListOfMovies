package com.jriveiro.listofmovies.data.datasources

import android.app.Application
import android.location.Geocoder
import android.location.Location
import com.jriveiro.listofmovies.ui.common.getFromLocationCompat
import javax.inject.Inject

const val DEFAULT_REGION = "ES"

class RegionDataSource @Inject constructor(
    app: Application,
    private val locationDataSource: LocationDataSource
) {

    private val geocoder = Geocoder(app)

    suspend fun findLastRegion(): String =
        locationDataSource.findLastLocation()?.toRegion() ?: DEFAULT_REGION

    private suspend fun Location.toRegion(): String {
        val addresses = geocoder.getFromLocationCompat(latitude, longitude, 1)
        val region = addresses.firstOrNull()?.countryCode
        return region ?: DEFAULT_REGION
    }

}