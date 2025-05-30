package com.jriveiro.data.datasource

import com.jriveiro.domain.Location


interface LocationDataSource {
    suspend fun findLastLocation(): Location?
}
