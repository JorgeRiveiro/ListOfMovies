package com.jriveiro.listofmovies.data

import com.jriveiro.listofmovies.data.datasources.RegionDataSource
import javax.inject.Inject

class RegionRepository @Inject constructor(
    private val regionDataSource: RegionDataSource
) {
    suspend fun findLastRegion(): String = regionDataSource.findLastRegion()
}