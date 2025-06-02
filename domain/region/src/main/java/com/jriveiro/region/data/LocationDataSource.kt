package com.jriveiro.region.data

import com.jriveiro.region.entities.Location

interface LocationDataSource {
    suspend fun findLastLocation(): Location?
}